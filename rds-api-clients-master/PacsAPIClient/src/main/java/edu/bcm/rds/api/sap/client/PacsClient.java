package edu.bcm.rds.api.sap.client;

import org.dcm4che3.data.*;
import org.dcm4che3.net.*;
import org.dcm4che3.net.pdu.AAssociateRQ;
import org.dcm4che3.net.pdu.PresentationContext;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class PacsClient {
    private static final Logger LOGGER = Logger.getLogger(PacsRestClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("pacsClient");
    private static String aetitle = resourceBundle.getString("PACS_AETITLE");
    private final int maxPDULength = 16384;
    private String pacsHostname = resourceBundle.getString("PACS_HOSTNAME");
    private String pacsPort = resourceBundle.getString("PACS_PORT");

    public Association getAppEntityAssociation() {

        Association assoc = null;

        try {
            ApplicationEntity locAE = new ApplicationEntity();

            locAE.setAETitle(aetitle);
            locAE.setInstalled(true);

            Connection localConn = new Connection();
            localConn.setCommonName("loc_conn");
            localConn.setHostname(pacsHostname);
            localConn.setPort(Integer.valueOf(pacsPort));
            localConn.setProtocol(Connection.Protocol.DICOM);
            localConn.setInstalled(true);
            locAE.addConnection(localConn);

            ApplicationEntity remAE = new ApplicationEntity();

            remAE.setAETitle(aetitle);
            remAE.setInstalled(true);

            Connection remoteConn = new Connection();
            remoteConn.setCommonName("rem_conn");
            remoteConn.setHostname(pacsHostname);
            remoteConn.setPort(Integer.valueOf(pacsPort));
            remoteConn.setProtocol(Connection.Protocol.DICOM);
            remoteConn.setInstalled(true);
            remAE.addConnection(remoteConn);

            AAssociateRQ assocReq = new AAssociateRQ();
            assocReq.setCalledAET(remAE.getAETitle());
            assocReq.setCallingAET(locAE.getAETitle());
            assocReq.setApplicationContext("1.2.840.10008.3.1.1.1");
            assocReq.setImplClassUID("1.2.40.0.13.1.3");
            assocReq.setImplVersionName("dcm4che-5.16.2");
            assocReq.setMaxPDULength(maxPDULength);
            assocReq.setMaxOpsInvoked(0);
            assocReq.setMaxOpsPerformed(0);
            assocReq.addPresentationContext(new PresentationContext(1, "1.2.840.10008.1.1", "1.2.840.10008.1.2"));

            Device device = new Device("dcm4chee-arc");
            device.addConnection(localConn);
            device.addApplicationEntity(locAE);

            Executor exec = (Runnable command) -> {
            };
            device.setExecutor(exec);

            assoc = locAE.connect(localConn, remoteConn, assocReq);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IncompatibleConnectionException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return assoc;
    }


    public void getStudies(String patientId, String modality) {

        try {
            //--------------------------------------------------------
            // HERE follows setup of a query, using an Attributes object
            //--------------------------------------------------------
            Attributes query = new Attributes();

            // Indicate character set
            {
                int tag = Tag.SpecificCharacterSet;
                VR vr = ElementDictionary.vrOf(tag, query.getPrivateCreator(tag));
                query.setString(tag, vr, "ISO_IR 100");
            }

            // Study level query
            {
                int tag = Tag.QueryRetrieveLevel;
                VR vr = ElementDictionary.vrOf(tag, query.getPrivateCreator(tag));
                query.setString(tag, vr, "STUDY");
            }

            // PatientID = patientId
/*            {
                int tag = Tag.PatientID;
                VR vr = ElementDictionary.vrOf(tag, query.getPrivateCreator(tag));
                query.setString(tag, vr, patientId);
            }*/

            //AccessNumber = 201911260270
            {
                int tag = Tag.AccessionNumber;
                VR vr = ElementDictionary.vrOf(tag, query.getPrivateCreator(tag));
                query.setString(tag, vr, "201911260270");
            }
            // Optionally filter on modality in study if 'modality' is provided,
            // otherwise retrieve modality
            {
                int tag = Tag.ModalitiesInStudy;
                VR vr = ElementDictionary.vrOf(tag, query.getPrivateCreator(tag));
                if (null != modality && modality.length() > 0) {
                    query.setString(tag, vr, modality);
                } else {
                    query.setNull(tag, vr);
                }
            }

            // We are interested in study instance UID
            {
                int tag = Tag.StudyInstanceUID;
                VR vr = ElementDictionary.vrOf(tag, query.getPrivateCreator(tag));
                query.setNull(tag, vr);
            }

            // Do the actual query, needing an AppliationEntity (ae),
            // a local (local) and remote (remote) Connection, and
            // an AAssociateRQ (rq) set up earlier.

            // 1) Open a connection to the SCP
            Association assoc = getAppEntityAssociation();//ae.connect(local, remote, rq);

            // 2) Query
            int priority = 0x0002; // low for the sake of demo :)

            assoc.cfind(UID.StudyRootQueryRetrieveInformationModelFIND, priority, query, null,
                    new DimseRSPHandler(assoc.nextMessageID()) {

                        @Override
                        public void onDimseRSP(Association assoc, Attributes cmd, Attributes response) {

                            super.onDimseRSP(assoc, cmd, response);

                            int status = cmd.getInt(Tag.Status, -1);
                            if (Status.isPending(status)) {
                                //--------------------------------------------------------
                                // HERE follows handling of the response, which
                                // is just another Attributes object
                                //--------------------------------------------------------
                                String studyInstanceUID = response.getString(Tag.StudyInstanceUID);
                                System.out.println("********* studyInstanceUID: " + studyInstanceUID);
                                // etc...
                            }
                        }
                    });

/*            // 2 alternate)

            DimseRSP rsp = assoc.cfind(...);

            assoc.waitForOutstandingRSP();

            while (rsp.next()) {
                Attributes data = rsp.getDataset(); // then do something with the data...
            }*/

            // 3) Close the connection to the SCP
            if (assoc != null && assoc.isReadyForDataTransfer()) {
                assoc.waitForOutstandingRSP();
                assoc.release();
                assoc = null;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
