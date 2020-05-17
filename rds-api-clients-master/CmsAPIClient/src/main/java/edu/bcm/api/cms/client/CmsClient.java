package edu.bcm.api.cms.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bcm.api.cms.entity.*;
import edu.bcm.api.cms.util.ExcelHelper;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CmsClient {

    private static final Logger LOGGER = Logger.getLogger(CmsClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("cmsClient");
    private static String appToken = resourceBundle.getString("AppToken");

    private Client client = null;
    private String cmsServiceURL = null;
    private WebTarget cmsWebTarget = null;
    private ObjectMapper objectMapper = null;
    private String bcmSunshineServiceURL = null;

    public CmsClient() {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        try {
            //set default URL values
            this.cmsServiceURL = resourceBundle.getString("BASE_PACS_REST_URL");
            this.bcmSunshineServiceURL = resourceBundle.getString("BcmSunshineServiceURL");
            cmsWebTarget = client.target(UriBuilder.fromUri(getCmsServiceURL()).build());
            objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public CmsClient(String serviceURL, String managerURL) {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        this.cmsServiceURL = serviceURL;
        cmsWebTarget = client.target(UriBuilder.fromUri(getCmsServiceURL()).build());
        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    public List<CmsObject> getCmsDatasetByType(String dataType, String datasetID) {

        List<CmsObject> objects = new ArrayList<CmsObject>();
        List<CmsObject> newObjects = new ArrayList<CmsObject>();

        int limit = 5000, offset = 0;
        try {

            if (dataType != null && datasetID != null) {

                do {
                    //call the object/info API
                    Response response = cmsWebTarget.path("/" + datasetID)
                            //.queryParam("recipient_country", "United States")
                            .queryParam("recipient_state", "TX")
                            .queryParam("recipient_city", "Houston")
                            .queryParam("$limit", limit)
                            .queryParam("$offset", offset)
                            .queryParam("$$app_token", appToken).request(MediaType.APPLICATION_JSON).get(Response.class);

                    if (response != null && response.getStatus() == 200) {
                        String responseEntity = response.readEntity(String.class);
                        //use Jackson to extract returned JSON object into a corresponding Java Object
                        JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);

                        if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {

                            newObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                    new TypeReference<List<CmsResearchObject>>() {
                                    });
                            objects.addAll(newObjects);

                        } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {

                            newObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                    new TypeReference<List<CmsOwnershipObject>>() {
                                    });
                            objects.addAll(newObjects);

                        } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {

                            newObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                    new TypeReference<List<CmsGeneralObject>>() {
                                    });
                            objects.addAll(newObjects);
                        }

                    }
                    offset += limit;
                    LOGGER.info("**************** Size So far: " + objects.size());
                } while (limit <= newObjects.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objects;
    }

    public List<CmsObject> getCmsDataset4BCM(String dataType, String datasetID) {
        List<CmsObject> finalCmsObjects = null;
        List<CmsObject> cmsObjects = null;
        ExcelHelper excelHelper = new ExcelHelper();

        try {
            List<String> profilesCSVs = excelHelper.getProfileIdCSVs();
            String requestedColumns = excelHelper.getBcmColumns(dataType);

            if (profilesCSVs == null || profilesCSVs.isEmpty()) {
                return null;
            }

            String filterAttribute = "physician_profile_id";
            if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {
                filterAttribute = "principal_investigator_1_profile_id";
            }
            String where = "";
            finalCmsObjects = new ArrayList<CmsObject>();
            for (String profilesCSV : profilesCSVs) {
                cmsObjects = new ArrayList<CmsObject>();
                where = filterAttribute + " in(" + profilesCSV + ")";

                int limit = 50000, offset = 0, resultsSize = limit;

                while (resultsSize == limit) {
                    Response response = cmsWebTarget.path("/" + datasetID)
                            .queryParam("$limit", limit)
                            .queryParam("$offset", offset)
                            .queryParam("$select", requestedColumns)
                            .queryParam("$where", where)
                            .queryParam("$$app_token", appToken)
                            .request(MediaType.APPLICATION_JSON).get(Response.class);

                    if (response != null && response.getStatus() == 200) {
                        String responseEntity = response.readEntity(String.class);
                        //use Jackson to extract returned JSON object into a corresponding Java Object
                        JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                        if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {
                            cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                    new TypeReference<List<CmsResearchObject>>() {
                                    });

                        } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {
                            cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                    new TypeReference<List<CmsOwnershipObject>>() {
                                    });
                        } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {
                            cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                    new TypeReference<List<CmsGeneralObject>>() {
                                    });
                        }
                    }
                    finalCmsObjects.addAll(cmsObjects);
                    offset += limit;
                    resultsSize = cmsObjects.size();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalCmsObjects;
    }

    public List<String> getCmsDatasetForBCM(String dataType, List<String> profileIDs, String setId) {
        List<CmsObject> cmsObjects = null;
        List<String> results = new ArrayList<String>();

        ExcelHelper excelHelper = new ExcelHelper();
        StringBuilder resultStr = null;
        int totalDatasetSize = 0;

        try {
            List<String> profilesCSVs = null;

            if (profileIDs == null) {
                profilesCSVs = excelHelper.getProfileIdCSVs();
            } else {
                profilesCSVs = profileIDs;
            }
            //    String requestedColumns = excelHelper.getBcmColumns(dataType);

            if (profilesCSVs == null || profilesCSVs.isEmpty() || dataType == null) {
                return new ArrayList<>();//return empty list
            }

            resultStr = new StringBuilder();
            String datasetID = null;
            if (setId == null || "null".equalsIgnoreCase(setId)) {
                if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {
                    datasetID = resourceBundle.getString("Research2017DatasetID");
                } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {
                    datasetID = resourceBundle.getString("General2017DatasetID");
                } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {
                    datasetID = resourceBundle.getString("Ownership2017DatasetID");
                }
            } else {
                datasetID = setId;
            }

            String filterAttribute = "physician_profile_id";
            if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {
                filterAttribute = "principal_investigator_1_profile_id ";
            }
            LOGGER.info("************ about to start data loading with datasetID = " + datasetID + " *********************");
            if (datasetID == null || datasetID.equalsIgnoreCase("null")) {
                return results;
            }

            String where = "";
            for (String profilesCSV : profilesCSVs) {
                where = filterAttribute + " in(" + profilesCSV + ")";

                int limit = 50000, offset = 0, resultsSize = limit;

                while (resultsSize == limit) {
                    // LOGGER.info("************ resultsSize = "+ resultsSize + "; Limit = " + limit);

                    Response response = cmsWebTarget.path("/" + datasetID)
                            .queryParam("$limit", limit)
                            .queryParam("$offset", offset)
                            //   .queryParam("$select", requestedColumns)
                            .queryParam("$where", where)
                            .queryParam("$$app_token", appToken)
                            .request(MediaType.APPLICATION_JSON).get(Response.class);
                    // LOGGER.info("************ response = " + response);

                    if (response != null && response.getStatus() == 200) {
                        String responseEntity = response.readEntity(String.class);
                        // LOGGER.info(responseEntity);

                        resultStr.append(responseEntity);
                        JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                        cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                new TypeReference<List<CmsObject>>() {
                                });
                        offset += limit;
                        LOGGER.info("************ new Offset = " + offset);

                        resultsSize = cmsObjects.size();
                        if (resultsSize > 0) {
                            results.add(responseEntity);
                            totalDatasetSize += resultsSize;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("************ totalDatasetSize = " + totalDatasetSize);

        return results;
    }

    public List<CmsObject> filterCmsDatasetForBCM(String dataType, List<CmsObject> dataset) {

        List<CmsObject> finalCmsObjects = null;

        ExcelHelper excelHelper = new ExcelHelper();
        try {
            String profilesCSV = excelHelper.getProfileIdCSV();

            if (profilesCSV == null || profilesCSV.isEmpty()) {
                return null;
            }

            if (dataType != null && dataset != null) {

                String[] tokens = profilesCSV.split(",");
                List<String> profileIDs = new ArrayList<>();
                for (String token : tokens) {
                    profileIDs.add(token);
                    //   LOGGER.info(token);
                }
                finalCmsObjects = new ArrayList<CmsObject>();
                String profileId = null;
                for (CmsObject cmsObject : dataset) {

                    if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {
                        CmsResearchObject obj = (CmsResearchObject) cmsObject;
                        profileId = obj.getPrincipalInvestigator1ProfileId();
                        // LOGGER.info(profileId);

                        if (profileId != null && profileIDs.contains(profileId)) {
                            finalCmsObjects.add(obj);
                        }
                    } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {
                        CmsGeneralObject obj = (CmsGeneralObject) cmsObject;
                        profileId = obj.getPhysicianProfileId();
                        if (profileId != null && profileIDs.contains(profileId)) {
                            finalCmsObjects.add(obj);
                        }
                    } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {
                        CmsOwnershipObject obj = (CmsOwnershipObject) cmsObject;
                        profileId = obj.getPhysicianProfileId();
                        if (profileId != null && profileIDs.contains(profileId)) {
                            finalCmsObjects.add(obj);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return finalCmsObjects;
    }

    public Integer getCmsDatasetSize(String dataType, String datasetID) {

        Integer size = 0;
        ExcelHelper excelHelper = new ExcelHelper();
        List<String> profilesCSVs = excelHelper.getProfileIdCSVs();
        List<CmsObject> cmsObjects = null;

        if (profilesCSVs == null || profilesCSVs.isEmpty()) {
            return null;
        }

        try {

            StringBuilder profileCSV = new StringBuilder();//profilesCSVs.get(2);
            for (String str : profilesCSVs) {
                profileCSV.append(str);
            }

            String query = "$select=count(physician_profile_id)&$where=physician_profile_id IN (" + profileCSV.toString() + ")";

            Response response = cmsWebTarget.path("/" + datasetID + ".json")
                    .queryParam("$where", "physician_profile_id IN (" + profileCSV.toString() + ")")
                    .queryParam("$$app_token", appToken).request(MediaType.APPLICATION_JSON).get(Response.class);


            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);

                if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {
                    cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                            new TypeReference<List<CmsResearchObject>>() {
                            });
                } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {
                    cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                            new TypeReference<List<CmsOwnershipObject>>() {
                            });
                } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {
                    cmsObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                            new TypeReference<List<CmsGeneralObject>>() {
                            });
                }

                if (cmsObjects != null) {
                    size = cmsObjects.size();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return size;
    }

    public List<CmsGeneralObject> getCmsGeneralDataset(String datasetID) {

        List<CmsGeneralObject> generalObjects = null;

        try {

            //call the object/info API
            Response response = cmsWebTarget.path("/" + datasetID)
                    .queryParam("recipient_state", "TX")
                    .queryParam("recipient_city", "Houston")
                    .queryParam("$$app_token", appToken).request(MediaType.APPLICATION_JSON).get(Response.class);

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);
                generalObjects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<CmsGeneralObject>>() {
                        });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generalObjects;
    }

    public List<String> getCmsDataAttributeNames(String dataType, String datasetID) {

        List<CmsObject> objects = null;
        List<String> attrNames = null;

        try {

            if (dataType != null && datasetID != null) {

                //call the object/info API
                Response response = cmsWebTarget.path("/" + datasetID)
                        .queryParam("recipient_state", "TX")
                        //.queryParam("recipient_city", "Houston")
                        .queryParam("$$app_token", appToken).request(MediaType.APPLICATION_JSON).get(Response.class);

                if (response != null && response.getStatus() == 200) {
                    String responseEntity = response.readEntity(String.class);

                    //use Jackson to extract returned JSON object into a corresponding Java Object
                    JsonNode jsonNode = objectMapper.readValue(responseEntity, JsonNode.class);

                    if (dataType.equalsIgnoreCase(CmsDataTypes.RESEARCH)) {

                        objects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                new TypeReference<List<CmsResearchObject>>() {
                                });

                    } else if (dataType.equalsIgnoreCase(CmsDataTypes.OWNERSHIP)) {

                        objects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                new TypeReference<List<CmsOwnershipObject>>() {
                                });

                    } else if (dataType.equalsIgnoreCase(CmsDataTypes.GENERAL)) {

                        objects = objectMapper.readValue(objectMapper.treeAsTokens(jsonNode),
                                new TypeReference<List<CmsGeneralObject>>() {
                                });
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attrNames;
    }

    public String getCmsServiceURL() {
        return cmsServiceURL;
    }

    public void setCmsServiceURL(String cmsServiceURL) {
        this.cmsServiceURL = cmsServiceURL;
    }

    public WebTarget getCmsWebTarget() {
        return cmsWebTarget;
    }

    public void setCmsWebTarget(WebTarget cmsWebTarget) {
        this.cmsWebTarget = cmsWebTarget;
    }

    public void loadSunshineData() {

        try {

            WebTarget webTarget = null;//client.target(UriBuilder.fromUri("http://localhost:8080/sunshineService/api/cms").build());
            webTarget = client.target(UriBuilder.fromUri("http://ecw-rapiws-d01.ad.bcm.edu:8080/sunshineService/api").build());
            //  webTarget = client.target(UriBuilder.fromUri("http://localhost:8080/sunshineService/api").build());

            Response response = null;

/*            response = webTarget.path("/loadGeneralData").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadGeneralData Status = "+response.getStatus());*/

/*            response = webTarget.path("/loadResearchData").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadResearchData Status = "+response.getStatus());*/

/*            response = webTarget.path("/loadOwnershipData").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadOwnershipData Status = "+response.getStatus());*/


            response = webTarget.path("/loadProfiles").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadProfiles Status = " + response.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<String> getBcmPhysicianProfileIDs() {

        List<String> profileIDs = null;
        try {

            WebTarget webTarget = client.target(UriBuilder.fromUri(this.bcmSunshineServiceURL).build());

            Response response = null;

            response = webTarget.path("/profileIDs").request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("loadGeneralData Status = " + response.getStatus());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return profileIDs;
    }
}
