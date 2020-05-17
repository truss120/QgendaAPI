package edu.bcm.api.snow.client;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bcm.api.snow.entity.SGARequest;
import edu.bcm.api.snow.entity.SNOWResponse;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ServiceNowClient {

    private static final Logger LOGGER = Logger.getLogger(ServiceNowClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("serviceNowClient");
    //    private static String appToken = resourceBundle.getString("AppToken");
    private static final String USER = resourceBundle.getString("SNOW_USER");
    private static final String PW = resourceBundle.getString("SNOW_PW");
    private String baseApiURL = resourceBundle.getString("BASE_API_URL");
    private boolean testMode = false;
    private String sgaRequestsPath = resourceBundle.getString("SGA_REQUESTS_PATH");

    private Client client = null;
    private WebTarget snowWebTarget = null;
    private ObjectMapper objectMapper = null;


    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
        if (testMode) {
            baseApiURL = resourceBundle.getString("TEST_API_BASE_URL");
        } else {
            baseApiURL = resourceBundle.getString("BASE_API_URL");
        }
    }

    public ServiceNowClient() {

        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(ServiceNowClient.USER, ServiceNowClient.PW);
        ClientConfig config = new ClientConfig();
        config.register(feature);
        client = ClientBuilder.newClient(config);

        try {

            snowWebTarget = client.target(UriBuilder.fromUri(this.baseApiURL).build());
            objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            //get the default testMode
            this.setTestMode(Boolean.valueOf(resourceBundle.getString("TEST_MODE")));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public ServiceNowClient(String serviceURL, boolean testMode) {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        this.baseApiURL = serviceURL;
        this.setTestMode(testMode);
        snowWebTarget = client.target(UriBuilder.fromUri(this.baseApiURL).build());
        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<SGARequest> getAllSGARequests() {

        SNOWResponse snowResponse = null;
        List<SGARequest> sgaRequests = null;

        try {

            this.snowWebTarget = this.client.target(this.baseApiURL);
            LOGGER.info("***** URI: " + this.snowWebTarget.getUri().toASCIIString());

            //call the object/info API
            Response response = this.snowWebTarget.path(sgaRequestsPath)
                    //.queryParam("sysparm_limit", 1000)
                    .request(MediaType.APPLICATION_JSON).get(Response.class);

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                //  LOGGER.info(responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                snowResponse = objectMapper.readValue(responseEntity, SNOWResponse.class);
                sgaRequests = snowResponse.getResult();

                LOGGER.info("***** # of Requests = " + sgaRequests.size());

                // remove non-sgas
                int counter = 0;
                for (SGARequest req : sgaRequests) {
                    if (req.getAccountType() != null && req.getAccountType().toLowerCase().contains("sga")) {
                        counter++;
                    } else {
                        // LOGGER.info("***** AccountType = " + req.getAccountType());
                    }
                }
                LOGGER.info("***** # of SGAs = " + counter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sgaRequests;
    }

    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSGARequestStrings() {

        StringBuilder guestsString = new StringBuilder();
        SNOWResponse snowResponse = null;
        List<SGARequest> requests = null;
        String responseEntity = null;

        try {
            // this.client.
            if (this.snowWebTarget == null) {
                this.snowWebTarget = this.client.target(this.baseApiURL);
            }
            //call the object/info API
            Response response =
                    this.snowWebTarget.path(sgaRequestsPath).request(MediaType.APPLICATION_JSON).get(Response.class);

            if (response != null && response.getStatus() == 200) {

                responseEntity = response.readEntity(String.class);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                snowResponse = objectMapper.readValue(responseEntity, SNOWResponse.class);
                requests = snowResponse.getResult();

                guestsString.append("["); // start JSON array

                for (SGARequest req : requests) {

                    // omit non-sgas
                    if (req.getAccountType() != null && req.getAccountType().toLowerCase().contains("sga")) {

                        // reformat terminationDate & DOB from "MM/dd/yyyy" to a JSON parseable format like "yyyy-MM-dd"
                        req.setTerminationDate(this.reformatDateString(req.getTerminationDate()));
                        req.setDateOfBirth(this.reformatDateString(req.getDateOfBirth()));

                        guestsString.append(req.toJsonString()).append(",");
                    }
                }

                guestsString.deleteCharAt(guestsString.lastIndexOf(",")); //remove trailing comma
                guestsString.append("]");//close JSON array

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }

    public String getBaseApiURL() {
        return baseApiURL;
    }

    public void setBaseApiURL(String baseApiURL) {
        this.baseApiURL = baseApiURL;
    }

    public String reformatDateString(String dateString) {

        String reformattedDateString = dateString;

        if (dateString != null && (dateString.indexOf("/") < 4 || dateString.indexOf("-") < 4)) {

            String[] tokens = dateString.split("/");
            if (tokens.length < 3) {
                tokens = dateString.split("-");
            }

            reformattedDateString = tokens[2] + "-" + tokens[0] + "-" + tokens[1];
        }

        return reformattedDateString;
    }

}
