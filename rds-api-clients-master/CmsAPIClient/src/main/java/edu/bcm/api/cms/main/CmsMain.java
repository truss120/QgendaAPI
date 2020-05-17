package edu.bcm.api.cms.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import edu.bcm.api.cms.client.CmsClient;
import edu.bcm.api.cms.entity.CmsDataTypes;
import edu.bcm.api.cms.entity.CmsObject;
import edu.bcm.api.cms.entity.CmsOwnershipObject;
import edu.bcm.api.cms.entity.CmsResearchObject;
import edu.bcm.api.cms.util.ExcelHelper;

import java.io.FileWriter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CmsMain {

    private static ResourceBundle cmsResourceBundle = ResourceBundle.getBundle("cmsClient");
    private static final Logger LOGGER = Logger.getLogger(CmsClient.class.getName());

    public static void main(String[] args) {

        CmsClient client = new CmsClient();
        ExcelHelper excelHelper = new ExcelHelper();

        try {

            client.loadSunshineData();
            System.exit(1);

            String dataType = CmsDataTypes.GENERAL;
            FileWriter writer = null;
            List<CmsObject> objects = null;


            if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {

                writer = new FileWriter("cmsResearchDataset.json");
                objects = client.getCmsDataset4BCM(CmsDataTypes.RESEARCH, cmsResourceBundle.getString("Research2016DatasetID"));

                for (CmsObject obj : objects) {
                    CmsResearchObject researchObject = (CmsResearchObject) obj;
                }
            } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {

                writer = new FileWriter("cmsOwnershipDataset.json");
                objects = client.getCmsDataset4BCM(CmsDataTypes.OWNERSHIP, cmsResourceBundle.getString("Ownership2016DatasetID"));
                for (CmsObject obj : objects) {
                    CmsOwnershipObject ownershipObject = (CmsOwnershipObject) obj;
                    writer.write(ownershipObject.toString());
                }
            } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {

                writer = new FileWriter("cmsGeneralDataset.json");
                // objects = client.getCmsDatasetForBCM(CmsDataTypes.GENERAL, cmsResourceBundle.getString("General2016DatasetID"));
                List<String> objectsStr = client.getCmsDatasetForBCM(CmsDataTypes.GENERAL, null, null);
                for (String obj : objectsStr) {
                    LOGGER.info(obj);
                }
            }
            if (writer != null) {
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = objectWriter.writeValueAsString(objects);

                mapper.writeValue(writer, json);
                writer.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
