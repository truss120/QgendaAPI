package edu.bcm.api.taleo.client;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bcm.api.taleo.entity.*;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class TaleoClient {

    private static final Logger LOGGER = Logger.getLogger(TaleoClient.class.getName());
    private ClientConfig config = null;

    private String taleoServiceURL = null;
    private String taleoManagerURL = null;
    private ObjectMapper objectMapper;

    private Client client = null;
    private WebTarget taleoWebTarget = null;
    private WebTarget taleoManagerWebTarget = null;

    public TaleoClient() {

        config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        try {
            //set default URL values
            this.taleoManagerURL = "https://tbe.taleo.net/MANAGER/dispatcher/api/v1/serviceUrl";
            this.taleoServiceURL = "https://chk.tbe.taleo.net/chk01/ats/api/v1";
            taleoWebTarget = client.target(UriBuilder.fromUri(this.getTaleoServiceURL()).build());
            taleoManagerWebTarget = client.target(UriBuilder.fromUri(this.getTaleoManagerURL()).build());

            objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public TaleoClient(String serviceURL, String managerURL) {

        config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        this.taleoServiceURL = serviceURL;
        this.taleoManagerURL = managerURL;

        taleoWebTarget = client.target(UriBuilder.fromUri(serviceURL).build());
        taleoManagerWebTarget = client.target(UriBuilder.fromUri(managerURL).build());

        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    public String getTaleoServiceURL() {
        return taleoServiceURL;
    }

    public void setTaleoServiceURL(String taleoServiceURL) {
        this.taleoServiceURL = taleoServiceURL;
    }

    public WebTarget getTaleoServiceWebResource() {
        return taleoWebTarget;
    }

    public void setTaleoServiceWebResource(WebTarget taleoServiceWebResource) {
        this.taleoWebTarget = taleoServiceWebResource;
    }

    public WebTarget getTaleoManagerWebResource() {
        return taleoManagerWebTarget;
    }

    public void setTaleoManagerWebResource(WebTarget taleoManagerWebResource) {
        this.taleoManagerWebTarget = taleoManagerWebResource;
    }

    public String getTaleoManagerURL() {
        return taleoManagerURL;
    }

    public void setTaleoManagerURL(String taleoManagerURL) {
        this.taleoManagerURL = taleoManagerURL;
    }

    public List<TaleoObject> getTaleoObjects(AuthToken authToken) {

        List<TaleoObject> objects = null;
        TaleoResponse taleoResponse;

        try {
            //call the object/info API
            Response response = taleoWebTarget.path("/object/info").request(MediaType.APPLICATION_JSON)
                    .cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                objects = taleoResponse.getResponse().getObjects();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public List<SearchResults> getCandidates(AuthToken authToken) {

        List<SearchResults> searchResults = null;
        TaleoResponse taleoResponse;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/candidate/search").request(MediaType.APPLICATION_JSON)
                    .cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                searchResults = taleoResponse.getResponse().getSearchResults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public Candidate getCandidateByID(AuthToken authToken, Integer candidateId) {
        TaleoResponse taleoResponse;
        Candidate candidate = null;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/candidate/" + candidateId)
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- responseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                candidate = taleoResponse.getResponse().getCandidate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candidate;
    }

    public Candidate getCandidateByEmail(AuthToken authToken, String email) {
        TaleoResponse taleoResponse;
        Candidate candidate = null;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/candidate/search").queryParam("email", email)
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- responseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                candidate = taleoResponse.getResponse().getCandidate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candidate;
    }

    public Object getCandidateStatus(AuthToken authToken, Integer candidateId) {
        List<SearchResults> searchResults = null;
        TaleoResponse taleoResponse;
        Candidate candidate = null;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/candidate/" + candidateId + "/status")
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- responseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                candidate = taleoResponse.getResponse().getCandidate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candidate;
    }

    public Department getSapDepartmentById(AuthToken authToken, Integer deptId) {
        TaleoResponse taleoResponse;
        Department department = null;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/department/" + deptId)
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                department = taleoResponse.getResponse().getDepartment();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return department;
    }

    public List<SearchResults> getRequistions(AuthToken authToken, int start, int limit) {

        List<SearchResults> searchResults = null;
        TaleoResponse taleoResponse;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/requisition/search")
                    .queryParam("start", Integer.toString(start)).queryParam("limit", Integer.toString(limit))
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();
            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                searchResults = taleoResponse.getResponse().getSearchResults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public List<SearchResults> getRequistionsByDateRange(AuthToken authToken, Date fromDate, Date toDate) {

        List<SearchResults> searchResults = null;
        TaleoResponse taleoResponse;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

        try {
            //convert the dates to Strings
            String fromDateStr = dateFormat.format(fromDate);
            String toDateStr = dateFormat.format(toDate);

            //make the rest call
            Response response = taleoWebTarget.path("/object/requisition/search")
                    .queryParam("SAPStartDate_from", fromDateStr).queryParam("SAPStartDate_to", toDateStr)
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- ResponseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                searchResults = taleoResponse.getResponse().getSearchResults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public List<SearchResults> getRequistionsByDate(AuthToken authToken, Date fromDate) {

        List<SearchResults> searchResults = null;
        TaleoResponse taleoResponse;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

        try {
            //convert the dates to Strings
            String fromDateStr = dateFormat.format(fromDate);

            //make the rest call
            Response response = taleoWebTarget.path("/object/requisition/search")
                    .queryParam("SAPStartDate_from", fromDateStr)
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);
                searchResults = taleoResponse.getResponse().getSearchResults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public List<RequisitionOwner> getRequisitionOwners(AuthToken authToken, int reqId) {

        List<RequisitionOwner> owners = null;
        TaleoResponse taleoResponse;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/requisition/" + reqId + "/owners")
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();
            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- ResponseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);
                owners = taleoResponse.getResponse().getOwners();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return owners;
    }

    public List<CandToReqs> getCandidateApplications(AuthToken authToken, Integer requisitionId) {

        List<CandToReqs> candToReqs = null;
        TaleoResponse taleoResponse;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/candidateapplication")
                    .queryParam("requisitionId", requisitionId.toString())
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- ResponseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);
                candToReqs = taleoResponse.getResponse().getCandToReqs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candToReqs;
    }

    public List<CandToReqs> getTaleoEntityLinksByRequisition(AuthToken authToken, Integer requisitionId) {

        List<CandToReqs> candToReqs = null;
        TaleoResponse taleoResponse;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/entitylink/requistion/" + requisitionId)
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();
            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                LOGGER.fine("-------------------------- ResponseEntity: " + responseEntity);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);
                candToReqs = taleoResponse.getResponse().getCandToReqs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candToReqs;
    }

    public List<SearchResults> getRequistionOwners(AuthToken authToken) {

        List<SearchResults> searchResults = null;
        TaleoResponse taleoResponse;

        try {
            //make the rest call
            Response response = taleoWebTarget.path("/object/requisitionowner/search")
                    .request(MediaType.APPLICATION_JSON).cookie(authToken.getAuthCookie()).get();

            String responseEntity;

            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);

                //use Jackson to extract returned JSON object into a corresponding Java Object
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);
                searchResults = taleoResponse.getResponse().getSearchResults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public AuthToken login(String orgCode, String userName, String pw) {

        AuthToken authToken = null;
        TaleoResponse taleoResponse;
        TaleoResponseDetail taleoResponseDetail = null;

        try {
            //call the login API
            Form form = new Form();
            form.param("orgCode", orgCode);
            form.param("userName", userName);
            form.param("password", pw);

            Response response = taleoWebTarget.path("/login")
                    .request(MediaType.APPLICATION_JSON).post(Entity.entity(form, MediaType.APPLICATION_JSON_TYPE));

            //extract the returned JSON and create a Java Object to contain the token & cookie info
            String responseEntity;
            if (response != null && response.getStatus() == 200) {
                responseEntity = response.readEntity(String.class);
                taleoResponse = objectMapper.readValue(responseEntity, TaleoResponse.class);

                String token = taleoResponse.getResponse().getAuthToken();
                LOGGER.fine("Login AuthToken = " + token);

                //prepare the authToken to be returned
                authToken = new AuthToken();
                authToken.setToken(token);
                Cookie authCookie = new Cookie("authToken", token);
                authToken.setAuthCookie(authCookie);

                if (token == null) {
                    LOGGER.info("--------- Could not login to the Taleo API ----------");
                } else {
                    LOGGER.info("--------- Successfully logged into the the Taleo API ---------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authToken;
    }

    public Boolean logout() {

        Boolean success = false;

        try {
            // Form form = new Form();

            Response response = taleoWebTarget.path("/logout")
                    .request(MediaType.APPLICATION_JSON).post(Entity.entity(null, MediaType.APPLICATION_JSON_TYPE));

            String responseEntity;
            if (response != null && response.getStatus() == 200) {

                responseEntity = response.readEntity(String.class);
                TaleoResponseDetail taleoResponseDetail =
                        objectMapper.readValue(responseEntity, TaleoResponseDetail.class);

                success = taleoResponseDetail.getStatus().getSuccess();
                LOGGER.info("Logout Successful = " + success);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

}
