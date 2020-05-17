package edu.bcm.rds.api.sap.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class PacsRestClient {

    private static final Logger LOGGER = Logger.getLogger(PacsRestClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("pacsClient");

    private static String ACCEPT = "multipart/related";
    private static String CONTENT_TYPE = "application/dicom";

    private ResteasyClient client = null;
    private String serviceURL = null;
    private String tokenURL = null;

    ResteasyWebTarget webTarget = null;
    private ObjectMapper mapper = null;

    public PacsRestClient() {

        client = new ResteasyClientBuilder().build();

        try {
            //set default URL values
            this.serviceURL = resourceBundle.getString("BASE_PACS_REST_URL");
            this.tokenURL = resourceBundle.getString("KEYCLOAK_TOKEN_URL");
            webTarget = client.target(UriBuilder.fromPath(getServiceURL()));

            mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PacsRestClient(String serviceURL, String managerURL) {

        client = new ResteasyClientBuilder().build();

        this.serviceURL = serviceURL;
        webTarget = client.target(UriBuilder.fromPath(getServiceURL()));
        mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }


    public void getStudy(String accessToken, String instanceUID) {

        try {
            //call the object/info API
            Response response = webTarget.path("/studies/" + instanceUID)
                    .request()
                    .header("Content-Type", CONTENT_TYPE)
                    .header("Authorization", "Bearer " + accessToken)
                    .accept(ACCEPT)
                    .get(Response.class);

            if (response != null && response.getStatus() == 200) {

                InputStream is = (InputStream) response.getEntity();

                String filename = "/Users/Sanyang/Downloads/dicoms/" + instanceUID + ".dcm";
                FileOutputStream out = new FileOutputStream(filename);

                int len = 0;
                byte[] buffer = new byte[4096];
                while ((len = is.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
                out.close();
                is.close();

            } else {
                LOGGER.info("*** Response: " + response.readEntity(String.class));
            }

            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Object> getPatientStudyUIDs(String accessToken, String patientId) {

        List<Object> studyUIDs = null;

        try {
            //call the object/info API
            Response response = webTarget.path("/studies/")
                    .queryParam("PatientID", patientId)
                    .request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + accessToken)
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(Response.class);

/*            MultivaluedMap headers = response.getMetadata();
            Iterator iter = headers.keySet().iterator();
            while (iter.hasNext()) {
                Object key = iter.next();
                System.out.println(key + ":" + headers.get(key));
            }*/

            System.out.println("*** Response Status: " + response.getStatus());

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                System.out.println(responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = mapper.readValue(responseEntity, JsonNode.class);

                studyUIDs =
                        mapper.readValue(mapper.treeAsTokens(jsonNode), new TypeReference<List<Object>>() {
                        });

            } else {
                LOGGER.info("*** Response: " + response.toString());
            }

            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studyUIDs;
    }


    public List<Object> getPatients(String accessToken) {

        List<Object> patients = null;

        try {
            //call the object/info API
            Response response = webTarget.path("/patients")
                    //    .queryParam("includedefaults", true)
                    //    .queryParam("withoutstudies", true)
                    .request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + accessToken)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(Response.class);

            System.out.println("*** Response Status: " + response.getStatus());

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = mapper.readValue(responseEntity, JsonNode.class);

                patients = mapper.readValue(mapper.treeAsTokens(jsonNode), new TypeReference<List<Object>>() {
                });

            } else {
                LOGGER.info("*** Response: " + response.toString());
            }

            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patients;
    }

    public Long getPatientCount(String accessToken) {

        Long patientCount = null;
        //http://test-ng:8080/dcm4chee-arc/aets/dcm4chee/rs/patients?accept=application%2Fdicom%2Bjson&includedefaults=true&withoutstudies=true

        try {
            //call the object/info API
            Response response = webTarget.path("/patients/count")
                    .request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + accessToken)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(Response.class);

            System.out.println("*** Response Status: " + response.getStatus());

            if (response != null && response.getStatus() == 200) {

                Object responseEntity = response.readEntity(Object.class);
                System.out.println("*** Patient Count: " + responseEntity.toString());


            } else {
                LOGGER.info("*** Response: " + response.toString());
            }

            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientCount;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public ResteasyWebTarget getWebTarget() {
        return webTarget;
    }

    public void setWebTarget(ResteasyWebTarget webTarget) {
        this.webTarget = webTarget;
    }

    public String getTokenURL() {
        return tokenURL;
    }

    public void setTokenURL(String tokenURL) {
        this.tokenURL = tokenURL;
    }

}
