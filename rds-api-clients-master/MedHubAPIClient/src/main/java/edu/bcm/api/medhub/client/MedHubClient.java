package edu.bcm.api.medhub.client;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bcm.api.medhub.entity.MedHubResident;
import edu.bcm.api.medhub.entity.PdmUser;
import edu.bcm.api.medhub.entity.Program;
import edu.bcm.api.medhub.entity.ResidentSummary;
import edu.bcm.api.medhub.util.AccountRequest;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.util.*;
import java.util.logging.Logger;

public class MedHubClient {

    private static final Logger LOGGER = Logger.getLogger(MedHubClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("medhubClient");
    //    private static String appToken = resourceBundle.getString("AppToken");
    private static final String PRIVATE_KEY = resourceBundle.getString("PrivateKey");
    private static final String CLIENT_ID = resourceBundle.getString("ClientID");
    private String baseApiURL = resourceBundle.getString("BASE_API_URL");
    private boolean testMode = true;
    //private String testApiPath = resourceBundle.getString("TEST_API_PATH");

    private Client client = null;
    private WebTarget medhubWebTarget = null;
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

    public MedHubClient() {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        client.property(ClientProperties.CONNECT_TIMEOUT, 45000);//45secs
        client.property(ClientProperties.READ_TIMEOUT, 45000);//45secs

        try {

            this.setTestMode(Boolean.valueOf(resourceBundle.getString("TEST_MODE")));
            medhubWebTarget = client.target(UriBuilder.fromUri(getBaseApiURL()).build());
            objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MedHubClient(String serviceURL) {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        if (serviceURL != null) {
            this.baseApiURL = serviceURL;
        }

        medhubWebTarget = client.target(UriBuilder.fromUri(this.getBaseApiURL()).build());
        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    public List<MedHubResident> getMedhubObjects() {

        List<MedHubResident> objects = new ArrayList<MedHubResident>();


        String request = "";
        long timestamp = System.currentTimeMillis() / 1000;

        String verify = getVerificationKey(request, timestamp);

        try {
            //call the object/info API
            Response response = medhubWebTarget.path("/users/residents")
                    .request(MediaType.APPLICATION_JSON).get(Response.class);

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);

                objects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<MedHubResident>>() {
                        });
            }

            for (Object obj : objects) {
                LOGGER.info(obj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objects;
    }

    public List<ResidentSummary> getActiveResidents() {

        List<ResidentSummary> residents = new ArrayList<ResidentSummary>();
        List<ResidentSummary> allResidents = new ArrayList<ResidentSummary>();

        String requestString = "";
        long timestamp;
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            List<String> programIDs = this.getAllProgramIDs();

            for (String programID : programIDs) {

                timestamp = Instant.now().getEpochSecond();
                requestString = "{\"programID\":\"" + programID + "\"}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residents").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    //  LOGGER.info("responseEntity == "+ responseEntity);

                    //use Jackson to extract returned JSON object into a corresponding Java Object
                    JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                    residents = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                            new TypeReference<List<ResidentSummary>>() {
                            });
                    allResidents.addAll(residents);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allResidents;
    }

    public List<ResidentSummary> getActiveResidentsByProgram(int programID) {

        List<ResidentSummary> residents = new ArrayList<ResidentSummary>();

        String requestString = "";
        long timestamp;
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            timestamp = Instant.now().getEpochSecond();
            requestString = "{\"programID\":\"" + programID + "\"}";
            JsonNode requestJson = objectMapper.readTree(requestString);

            verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestJson.toString());

            Response response = medhubWebTarget.path("users/residents").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                //  LOGGER.info("responseEntity == "+ responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                residents = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<ResidentSummary>>() {
                        });
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents;
    }

    public List<String> getAllProgramIDs() {

        List<String> programIDs = new ArrayList<String>();
        MedHubResident resident = null;

        String requestString = "";
        long timestamp;
        String verificationKey;

        try {

            timestamp = Instant.now().getEpochSecond();
            verificationKey = this.getVerificationKey(requestString, timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestString);

            Response response = medhubWebTarget.path("programs/all").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);

                List<Program> programList = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<Program>>() {
                        });

                for (Program program : programList) {
                    programIDs.add(program.getProgramID());
                }
                // LOGGER.info("ResponseEntity = " + responseEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return programIDs;
    }

    public MedHubResident getResidentDetails(String userID) {

        MedHubResident resident = null;

        String requestString = "";
        long timestamp;
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            timestamp = Instant.now().getEpochSecond();//Unix Timestamp
            requestString = "{\"userID\":" + userID + "}";
            JsonNode requestJson = objectMapper.readTree(requestString);

            verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestJson.toString());

            Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                // LOGGER.info(responseEntity);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                resident = objectMapper.readValue(responseEntity, MedHubResident.class);

            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resident;
    }

    public String getResidentDetailsString(String userID) {

        String residentString = null;

        String requestString = "";
        long timestamp;
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            timestamp = Instant.now().getEpochSecond();//Unix Timestamp
            requestString = "{\"userID\":" + userID + "}";
            JsonNode requestJson = objectMapper.readTree(requestString);

            verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestJson.toString());

            Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {
                residentString = response.readEntity(String.class);
                // LOGGER.info(responseEntity);
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residentString;
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<MedHubResident> getResidentDetailsList(List<String> userIDs) {

        List<MedHubResident> residents = new ArrayList<MedHubResident>();
        MedHubResident resident;
        String requestString = "";
        long timestamp;
        String verificationKey;

        if (userIDs == null || userIDs.size() == 0) {
            return residents;
        }

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            for (String userID : userIDs) {
                timestamp = Instant.now().getEpochSecond();//Unix Timestamp
                requestString = "{\"userID\":" + userID + "}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    //  LOGGER.info(responseEntity);
                    //use Jackson to extract returned JSON object into a corresponding Java Object
                    resident = objectMapper.readValue(responseEntity, MedHubResident.class);
                    residents.add(resident);
                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents;
    }

    public String getResidentDetailsStringList(List<String> userIDs) {

        StringBuilder residents = new StringBuilder();
        MedHubResident resident;
        String requestString = "";
        long timestamp;
        String verificationKey;

        if (userIDs == null || userIDs.size() == 0) {
            return residents.toString();
        }

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            residents.append("[");
            for (String userID : userIDs) {

                timestamp = Instant.now().getEpochSecond();//Unix Timestamp
                requestString = "{\"userID\":" + userID + "}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    // LOGGER.info(responseEntity);

                    residents.append(responseEntity);
                    residents.append(",");

                }
            }

            if (residents.lastIndexOf(",") >= 0 && residents.lastIndexOf(",") == residents.length() - 1) {
                residents.deleteCharAt(residents.lastIndexOf(","));
            }
            residents.append("]");


        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents.toString();
    }

    public String getFacultyDetailsStringList(List<String> userIDs) {

        StringBuilder faculties = new StringBuilder();
        MedHubResident resident;
        String requestString = "";
        long timestamp;
        String verificationKey;

        if (userIDs == null || userIDs.size() == 0) {
            return faculties.toString();
        }

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            faculties.append("[");
            for (String userID : userIDs) {

                timestamp = Instant.now().getEpochSecond();//Unix Timestamp
                requestString = "{\"userID\":" + userID + "}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    // LOGGER.info(responseEntity);

                    faculties.append(responseEntity);
                    faculties.append(",");

                }
            }

            if (faculties.lastIndexOf(",") >= 0 && faculties.lastIndexOf(",") == faculties.length() - 1) {
                faculties.deleteCharAt(faculties.lastIndexOf(","));
            }
            faculties.append("]");


        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return faculties.toString();
    }

    public String findResidentByEmployeeId(String employeeID) {

        String residentStr = null;
        String requestString = "";
        long timestamp;
        String verificationKey;
        List<ResidentSummary> residentSummaries = null;
        ResidentSummary residentSummary = null;
        try {

            medhubWebTarget = client.target(this.baseApiURL);

            timestamp = Instant.now().getEpochSecond();
            requestString = "{\"employeeID\":\"" + employeeID + "\"}";
            JsonNode requestJson = objectMapper.readTree(requestString);

            verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestJson.toString());

            Response response = medhubWebTarget.path("users/residentSearch").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                // LOGGER.info(responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                residentSummaries = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<ResidentSummary>>() {
                        });
                if (residentSummaries != null && residentSummaries.size() > 0) {
                    residentStr = objectMapper.writeValueAsString(residentSummaries.get(0));
                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residentStr;
    }

    public String residentSearch(String name, String username, String employeeID) {

        StringBuilder residentStr = new StringBuilder();

        StringBuilder requestString = new StringBuilder();
        long timestamp;
        String verificationKey;
        List<ResidentSummary> residentSummaries = null;
        try {

            if (name == null && username == null && employeeID == null) {
                return null;
            }
            medhubWebTarget = client.target(this.baseApiURL);

            timestamp = Instant.now().getEpochSecond();

            requestString.append("{");
            if (name != null) {
                requestString.append("\"name\":\"" + name + "\"");
                requestString.append(",");
            }
            if (username != null) {
                requestString.append("\"username\":\"" + username + "\"");
                requestString.append(",");
            }
            if (employeeID != null) {
                requestString.append("\"employeeID\":\"" + employeeID + "\"");
            }
            if (requestString.length() < 2) {
                //all parameters are null
                return null;
            } else if (requestString.charAt(requestString.length() - 1) == ',') {
                //remove trailing comma
                requestString.deleteCharAt(requestString.lastIndexOf(","));
            }
            requestString.append("}");

            //  LOGGER.info(requestString.toString());
            JsonNode requestJson = objectMapper.readTree(requestString.toString());

            verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestJson.toString());

            Response response = medhubWebTarget.path("users/residentSearch").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                // LOGGER.info("responseEntity = " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                residentSummaries = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<ResidentSummary>>() {
                        });

                if (residentSummaries != null && residentSummaries.size() > 0) {
                    //residentStr = objectMapper.writeValueAsString(residentSummaries.get(0));
                    residentStr.append("[");
                    for (ResidentSummary summary : residentSummaries) {
                        residentStr.append(objectMapper.writeValueAsString(summary));
                        residentStr.append(",");
                    }
                    if (residentStr.lastIndexOf(",") >= 0) {
                        residentStr.deleteCharAt(residentStr.lastIndexOf(","));
                    }
                    residentStr.append("]");
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residentStr.toString();
    }


    public String getNewResidents() {

        StringBuilder residents = new StringBuilder();
        MedHubResident resident;
        List<ResidentSummary> residentSummaries;
        String requestString = "";
        long timestamp;
        String verificationKey;

        try {

            residentSummaries = getActiveResidents();

            medhubWebTarget = client.target(this.baseApiURL);

            residents.append("[");
            for (ResidentSummary residentSummary : residentSummaries) {
                timestamp = Instant.now().getEpochSecond();
                requestString = "{\"userID\":\"" + residentSummary.getUserID() + "\"}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    // LOGGER.info(responseEntity);
                    resident = objectMapper.readValue(responseEntity, MedHubResident.class);
                    if (resident != null && resident.getEmployeeID() == null) {
                        residents.append(responseEntity);
                        residents.append(",");
                    }
                }
            }
            residents.deleteCharAt(residents.lastIndexOf(","));
            residents.append("]");

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents.toString();

    }

    public String getAllResidentsString() {

        StringBuilder residents = new StringBuilder();
        List<ResidentSummary> residentSummaries;
        String requestString = "";
        long timestamp;
        String verificationKey;

        try {

            residentSummaries = getActiveResidents();

            medhubWebTarget = client.target(this.baseApiURL);

            int numRes = 0;
            residents.append("[");
            for (ResidentSummary residentSummary : residentSummaries) {
                timestamp = Instant.now().getEpochSecond();
                requestString = "{\"userID\":\"" + residentSummary.getUserID() + "\"}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    //LOGGER.info(responseEntity);
                    residents.append(responseEntity);
                    residents.append(",");
                    numRes++;
                    LOGGER.info(numRes + " Records processed");
                }
            }
            residents.deleteCharAt(residents.lastIndexOf(","));
            residents.append("]");

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents.toString();
    }

    public String getAllResidentsString(long minUserId, long maxUserId) {

        StringBuilder residents = new StringBuilder();
        MedHubResident resident;
        String requestString = "";
        long timestamp;
        String verificationKey;

        try {

            medhubWebTarget = client.target(this.baseApiURL);

            int numRes = 0;
            residents.append("[");
            Response response;
            long userId = minUserId;

            do {

                timestamp = Instant.now().getEpochSecond();
                requestString = "{\"userID\":\"" + userId++ + "\"}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response == null || response.getStatus() == 400) {
                    response = medhubWebTarget.path("users/studentInfo").request(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
                }

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    //  LOGGER.info(responseEntity);
                    resident = objectMapper.readValue(responseEntity, MedHubResident.class);
                    if (resident != null) {
                        residents.append(responseEntity);
                        residents.append(",");
                    }
                    LOGGER.info("" + userId);
                    numRes++;
                }

            } while (userId <= maxUserId);

            LOGGER.info(numRes + " Records processed");

            if (residents.lastIndexOf(",") == residents.length() - 1) {
                residents.deleteCharAt(residents.lastIndexOf(","));
            }
            residents.append("]");

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents.toString();
    }

    public String getAllResidentsStringExhaustive() {

        StringBuilder residents = new StringBuilder();
        List<ResidentSummary> residentSummaries;
        String requestString = "";
        long timestamp;
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            int numRes = 0;
            residents.append("[");
            for (int userId = 10000; userId < 18000; userId++) {
                timestamp = Instant.now().getEpochSecond();
                requestString = "{\"userID\":\"" + userId + "\"}";
                JsonNode requestJson = objectMapper.readTree(requestString);

                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);
                    residents.append(responseEntity);
                    residents.append(",");
                    numRes++;
                }
            }
            residents.deleteCharAt(residents.lastIndexOf(","));
            residents.append("]");
            LOGGER.info("********* Number of Residents found = " + numRes);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents.toString();
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<MedHubResident> getAllResidentObjects() {

        List<MedHubResident> residents = new ArrayList<MedHubResident>();
        List<ResidentSummary> residentSummaries;
        MedHubResident resident = null;

        String requestString = "";
        long timestamp;
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);

            residentSummaries = getActiveResidents();

            for (ResidentSummary residentSummary : residentSummaries) {

                timestamp = Instant.now().getEpochSecond();
                requestString = "{\"userID\":\"" + residentSummary.getUserID() + "\"}";
                JsonNode requestJson = objectMapper.readTree(requestString);
                verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

                Form form = new Form();
                form.param("clientID", MedHubClient.CLIENT_ID);
                form.param("ts", String.valueOf(timestamp));
                form.param("type", "json");
                form.param("verify", verificationKey);
                form.param("request", requestJson.toString());

                Response response = medhubWebTarget.path("users/residentInfo").request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);

                    //use Jackson to extract returned JSON object into a corresponding Java Object
                    resident = objectMapper.readValue(responseEntity, MedHubResident.class);
                    residents.add(resident);
                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return residents;
    }

    public String updateResident(String userID, Map fields) {

        String responseEntity = null;
        StringBuilder requestString = new StringBuilder();
        long timestamp;
        String verificationKey;
        Response response;

        try {

            if (userID == null) {
                return "userID is required for update";
            }
            if (fields == null || fields.size() < 1) {
                //nothing to update
                return "Nothing to update. You must pass at least one field name-value pair to be updated.";
            }
            medhubWebTarget = client.target(this.baseApiURL);

            timestamp = Instant.now().getEpochSecond();

            requestString.append("{");
            requestString.append("\"userID\":\"" + userID + "\"");
            requestString.append(",");
            requestString.append(" \"fields\":[");
            Set fieldNames = fields.keySet();
            for (Object fieldName : fieldNames) {
                requestString.append("{\"");
                requestString.append(fieldName);
                requestString.append("\":\"");
                requestString.append(fields.get(fieldName));
                requestString.append("\"}");
                requestString.append(",");
            }
            //remove trailing comma
            requestString.deleteCharAt(requestString.lastIndexOf(","));
            requestString.append("]}");

            JsonNode requestJson = objectMapper.readTree(requestString.toString());

            verificationKey = this.getVerificationKey(requestJson.toString(), timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestJson.toString());

            LOGGER.info("########## Calling updateResident with requestString = " + requestString.toString());

            response = medhubWebTarget.path("users/residentUpdate").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            LOGGER.info("Response = " + response);

            if (response != null) {
                responseEntity = response.readEntity(String.class);
                // LOGGER.info("ResponseEntity = " + responseEntity);
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }

    public void loadNewResidents(String host) {

        try {

            String uri = "http://" + host + ":8080/pdmService/api";
            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());
            Response response = null;

            response = webTarget.path("/persons/loadNewResidents").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadAllResidents Status = " + response.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadAllResidents(String host) {

        try {
            client.property(ClientProperties.CONNECT_TIMEOUT, 600000);//45secs
            client.property(ClientProperties.READ_TIMEOUT, 600000);//45secs
            String uri = "http://" + host + ":8080/pdmService/api";

            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());

            Response response = null;


            response = webTarget.path("/persons/loadAllResidents").request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(null), Response.class);

            LOGGER.info("loadAllResidents Status = " + response.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadLdapPersons(String host) {

        try {
            client.property(ClientProperties.CONNECT_TIMEOUT, 600000);//45secs
            client.property(ClientProperties.READ_TIMEOUT, 600000);//45secs
            String uri = "http://" + host + ":8080/pdmService/api";

            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());

            Response response = null;


            response = webTarget.path("/persons/loadLdapPersons").request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(null), Response.class);

            LOGGER.info("loadLdapPersons Status = " + response.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateCamsIdm3(String host, AccountRequest accountRequest) {

        try {
            org.glassfish.jersey.client.ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);
            String uri = "http://" + host + ":8080/pdmService/api";

            // WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());
            WebTarget webTarget = client.target(uri);

            Response response = null;

            Form form = new Form();
            form.param("accountRequestId", String.valueOf(accountRequest.getAccountRequestId()));
            form.param("eca", accountRequest.getEca());
            form.param("bcmId", accountRequest.getBcmId());
            form.param("email", accountRequest.getEmail());

            response = webTarget.path("/accountRequests/updateCamsIdm3").request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(form, MediaType.APPLICATION_JSON));

            LOGGER.info("Response = " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testMedhubAPIConnection() {

        String requestString = "";
        long timestamp = Instant.now().getEpochSecond();
        String verificationKey;

        try {
            this.setTestMode(true);
            medhubWebTarget = client.target(this.baseApiURL);
            requestString = "";
            verificationKey = this.getVerificationKey(requestString, timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestString);

            //call the object/info API
            Response response = medhubWebTarget.path(baseApiURL).request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                // LOGGER.info(responseEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listAccessibleAPIs() {

        String requestString = "";
        long timestamp = Instant.now().getEpochSecond();
        String verificationKey;

        try {
            medhubWebTarget = client.target(this.baseApiURL);
            requestString = "";
            verificationKey = this.getVerificationKey(requestString, timestamp);

            Form form = new Form();
            form.param("clientID", MedHubClient.CLIENT_ID);
            form.param("ts", String.valueOf(timestamp));
            form.param("type", "json");
            form.param("verify", verificationKey);
            form.param("request", requestString);

            //call the object/info API
            Response response = medhubWebTarget.path("info/access").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                // LOGGER.info(responseEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getVerificationKey(String request, long timestamp) {

        String originalString =
                MedHubClient.CLIENT_ID + "|" + String.valueOf(timestamp) + "|" + MedHubClient.PRIVATE_KEY + "|" + request;
        String verificationKey = this.getSHA256Digest(originalString);

        return verificationKey;
    }

    public String getBaseApiURL() {
        return baseApiURL;
    }

    public void setBaseApiURL(String baseApiURL) {
        this.baseApiURL = baseApiURL;
    }

    public WebTarget getMedhubWebTarget() {
        return medhubWebTarget;
    }

    public void setMedhubWebTarget(WebTarget medhubWebTarget) {
        this.medhubWebTarget = medhubWebTarget;
    }

    public String getSHA256Digest(String originalString) {
        MessageDigest digest = null;
        byte[] encodedhash = null;
        StringBuilder sb = new StringBuilder();

        try {

            digest = MessageDigest.getInstance("SHA-256");
            // encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            encodedhash = digest.digest(originalString.getBytes());

            for (byte c : encodedhash) {
                sb.append(c);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //  return sb.toString();
        return bytesToHex(encodedhash);
    }

    public void init() throws KeyManagementException, NoSuchAlgorithmException {
        TrustManager[] noopTrustManager = new TrustManager[]{
                new X509TrustManager() {

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("ssl");
        sc.init(null, noopTrustManager, null);

        this.client = ClientBuilder.newBuilder().sslContext(sc).build();
        this.medhubWebTarget = this.client.target(this.baseApiURL);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void findPdmAccountMatches(String host, String accountRequest) {

        try {

            String uri = "http://" + host + ":8080/pdmService/api";
            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());

            Response response = webTarget.path("/accountRequests/matches").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(accountRequest, MediaType.APPLICATION_JSON));

            LOGGER.info("AccountMatch Status = " + response.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void getAllActivePersons(String host) {

        try {

            String uri = "http://" + host + ":8080/pdmService/api";
            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());
            Response response = null;

            response = webTarget.path("/persons/all").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("getAllActivePersons Status = " + response.getStatus());

            if (response != null && response.getStatus() == 200) {
                LOGGER.info(response.readEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void findAllMatches(String host) {

        try {

            String uri = "http://" + host + ":8080/pdmService/api";
            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());
            Response response = null;

            response = webTarget.path("/accountRequests/matches/all").request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(null, MediaType.APPLICATION_JSON));

            LOGGER.info("findAllMatches Status = " + response.getStatus());

            if (response != null && response.getStatus() == 200) {
                LOGGER.info(response.readEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void propagateAllPendingIDM3(String host) {

        try {

            String uri = "http://" + host + ":8080/pdmService/api";
            WebTarget webTarget = client.target(UriBuilder.fromUri(uri).build());
            Response response = null;

            response = webTarget.path("/accountRequests/propagateAllPendingIDM3").request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(null, MediaType.APPLICATION_JSON));

            LOGGER.info("propagateAllPendingIDM3 Status = " + response.getStatus());

            if (response != null && response.getStatus() == 200) {
                LOGGER.info(response.readEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getPdmToken(String hostname, String userName, String pw) {

        String authToken = null;

        try {
            //call the login API
            PdmUser user = new PdmUser();
            user.setUsername(userName);
            user.setPassword(pw);

            String url = "https://pdm-dev.bcm.edu/pdmService/api";
            medhubWebTarget = client.target(UriBuilder.fromUri(url).build());

/*            Response response = medhubWebTarget.path("/auth/token")
                    .request(MediaType.APPLICATION_JSON).post(Entity.entity(user, MediaType.APPLICATION_JSON));
                    */

            Response response = medhubWebTarget.path("/auth/token/" + userName + "/" + pw)
                    .request(MediaType.APPLICATION_JSON).post(Entity.entity(null, MediaType.APPLICATION_JSON));

            LOGGER.info("***** Response status = " + response.getStatus());

            //extract the returned JSON and create a Java Object to contain the token & cookie info
            String responseEntity;
            if (response != null && response.getStatus() == 200) {

                authToken = response.readEntity(String.class);
                LOGGER.info("Login AuthToken = " + authToken);

                //prepare the authToken to be returned

                if (authToken == null) {
                    LOGGER.info("--------- Could not login to the PDM API ----------");
                } else {
                    LOGGER.info("--------- Successfully logged into the PDM API ---------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authToken;
    }

    public void getAmulatoryEnrollmentCandidate(String accessToken, String eca) {

        try {
            String url = "https://pdm-dev.bcm.edu/pdmService/api/v1";

            medhubWebTarget = client.target(UriBuilder.fromUri(url).build());

            //call the object/info API
            Response response = medhubWebTarget.path("/persons/amb/" + eca)
                    .request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + accessToken)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(Response.class);

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                LOGGER.info("***** Amb Person = " + responseEntity);

            } else {
                LOGGER.info("*** Response: " + response);
            }

            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendImmunizationsReports(String host) {
        try {
            String url = "http://" + host + ":8080/pdmService/api";

            medhubWebTarget = client.target(UriBuilder.fromUri(url).build());

            //call the object/info API
            Response response = medhubWebTarget.path("/persons/reports/immunizations")
                    .request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(Response.class);

            if (response != null && response.getStatus() == 200) {
                LOGGER.info("*** Response: " + response);

                String responseEntity = response.readEntity(String.class);
                LOGGER.info("***** Immunizations Report = " + responseEntity);

            } else {
                LOGGER.info("*** Response: " + response);
            }

            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
