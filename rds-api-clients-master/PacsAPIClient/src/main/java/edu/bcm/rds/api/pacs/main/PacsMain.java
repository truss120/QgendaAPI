package edu.bcm.rds.api.pacs.main;

import edu.bcm.rds.api.sap.client.OpenIDClient;
import edu.bcm.rds.api.sap.client.PacsRestClient;

import java.util.List;

public class PacsMain {

    public static void main(String[] args) {

        OpenIDClient idClient = new OpenIDClient();

        // Get AccessToken
        String accessToken = idClient.getAccessToken();
        System.out.println(accessToken);

        //get study UIDs by PatientID
        // getPatientStudyUIDs(accessToken);

        // get a study based on UID
        getStudy(accessToken, "2.16.840.1.114151.1927370287155064015612555226179314298690191129");


        //   pacsClient.getStudies(null, null);

        //  pacsRestClient.getPatientCount(accessToken);
        // getPatients(accessToken);

    }

    private static void getStudy(String accessToken, String instanceUID) {

        PacsRestClient pacsRestClient = new PacsRestClient();

        pacsRestClient.getStudy(accessToken, instanceUID);
    }

    private static void getPatientStudyUIDs(String accessToken) {

        PacsRestClient pacsRestClient = new PacsRestClient();

        List<Object> studyUIDs = pacsRestClient.getPatientStudyUIDs(accessToken, "0302558906");

        if (studyUIDs != null) {
            for (Object uid : studyUIDs) {
                System.out.println(uid.toString());
            }
        }
    }

    private static void getPatients(String accessToken) {

        PacsRestClient pacsRestClient = new PacsRestClient();

        List<Object> patients = pacsRestClient.getPatients(accessToken);
        if (patients != null) {
            for (Object patient : patients) {
                System.out.println(patient.toString());
            }
        }
    }
}
