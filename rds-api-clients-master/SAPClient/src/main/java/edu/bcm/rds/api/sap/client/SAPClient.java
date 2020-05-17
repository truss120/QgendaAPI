package edu.bcm.rds.api.sap.client;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class SAPClient {

    private static final Logger LOGGER = Logger.getLogger(SAPClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("sapClient");

    private static String ACCEPT = MediaType.APPLICATION_XML;
    private static String CONTENT_TYPE = MediaType.APPLICATION_XML;
    private boolean testMode = true;
    private String baseApiURL = resourceBundle.getString("BASE_API_URL");

    private ObjectMapper mapper = null;
    private Client client = null;
    private WebTarget webTarget = null;

    public SAPClient() {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        try {

            this.setTestMode(Boolean.valueOf(resourceBundle.getString("TEST_MODE")));

            //set default URL values
            webTarget = client.target(UriBuilder.fromUri(getBaseApiURL()).build());
            mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            this.setTestMode(Boolean.valueOf(resourceBundle.getString("TEST_MODE")));

            mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public String getToken(String username, String password) {

        String token = null;

        try {

            String tokenRequest =
                    "<attrs xmlns=\"http://www.sap.com/rws/bip\">\n" +
                            "\t<attr name=\"password\" type=\"string\">" + password + "</attr>\n" +
                            "\t<attr name=\"clientType\" type=\"string\"></attr>\n" +
                            "\t<attr name=\"auth\" type=\"string\" possibilities=\"secEnterprise,secLDAP,secWinAD,secSAPR3\">secEnterprise</attr>\n" +
                            "\t<attr name=\"userName\" type=\"string\">" + username + "</attr>\n" +
                            "</attrs>";
            //  System.out.println(tokenRequest);

            Response response = webTarget.path("/logon/long")
                    .request()
                    .header("Content-Type", CONTENT_TYPE)
                    .accept(ACCEPT)
                    .post(Entity.xml(tokenRequest), Response.class);

            if (response != null && response.getStatus() == 200) {

/*
                String responseEntity = response.readEntity(String.class);
                  System.out.println("***** responseEntity:" + responseEntity);
               JacksonXmlModule xmlModule = new JacksonXmlModule();
                xmlModule.setDefaultUseWrapper(false);
                ObjectMapper objectMapper = new XmlMapper(xmlModule);
                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);*/

                token = response.getHeaderString("X-SAP-LogonToken");
                // System.out.println("***** token: " + token);

                response.close();

            } else {
                LOGGER.info("*** Response: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return token;
    }

    public String getSchedulingUrls(String token, String reportId) {

        String structure = null;

        try {

            Response response = webTarget.path("/infostore/" + reportId + "/scheduleForms")
                    .request()
                    .header("X-SAP-LogonToken", token)
                    .header("Content-Type", CONTENT_TYPE)
                    .accept(ACCEPT)
                    .get(Response.class);

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                //  System.out.println("***** responseEntity:" + responseEntity);
                structure = responseEntity;
                response.close();

            } else {
                LOGGER.info("*** Response: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return structure;
    }

    public void runReportNow(String token, String reportId) {

        try {

            Response response = webTarget.path("/infostore/" + reportId + "/scheduleForms/now")
                    .request()
                    .header("X-SAP-LogonToken", token)
                    .header("Content-Type", CONTENT_TYPE)
                    .accept(ACCEPT)
                    .get(Response.class);

            String responseEntity = response.readEntity(String.class);
            System.out.println("***** responseEntity:" + responseEntity);

            if (response != null && response.getStatus() == 2001) {

                String scheduleRequest =
                        "<entry xmlns=\"http://www.w3.org/2005/Atom\">" +
                                "<author>" +
                                "   <name>rtrivedi</name>" +
                                "   <uri>http://baybipa01.ad.bcm.edu:6405/biprws/infostore/4660356</uri>" +
                                "</author>" +
                                "<id>tag:sap.com,2010:bip-rs/FpHvSl1_kgkAcRIBAAA3QmoDAA06bQLV/scheduleForms/now</id>" +
                                "<title type=\"text\">Schedule ONBOARDING_REPORT_PSOA now</title>" +
                                "<updated>2019-09-17T17:53:11.393Z</updated>" +
                                "<content type=\"application/xml\">" +
                                "   <attrs xmlns=\"http://www.sap.com/rws/bip\">" +
                                "       <attr name=\"StartDate\" type=\"datetime\">2019-12-27T00:00:00.000Z</attr>" +
                                "       <attr name=\"EndDate\" type=\"datetime\">2019-12-30T00:00:00.000Z</attr>" +
                                "       <attr name=\"retriesAllowed\" type=\"int32\">0</attr>" +
                                "       <attr name=\"retryIntervalInSeconds\" type=\"int32\">1800</attr>" +
                                "   </attrs>" +
                                "</content>" +
                                "</entry>\n";

                Response schedulerResponse = webTarget.path("/infostore/" + reportId + "/scheduleForms/now")
                        .request()
                        .header("X-SAP-LogonToken", token)
                        .header("Content-Type", CONTENT_TYPE)
                        .accept(ACCEPT)
                        .post(Entity.xml(scheduleRequest), Response.class);

                System.out.println("***** schedulerResponse:" + schedulerResponse);
                response.close();

            } else {
                LOGGER.info("*** Response: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout() {

        try {
            //call the object/info API
            Response response = webTarget.path("/logoff")
                    .request()
                    .accept(ACCEPT)
                    .post(Entity.json(null), Response.class);

            if (response != null && response.getStatus() == 200) {

                String responseEntity = response.readEntity(String.class);
                System.out.println("***** responseEntity:" + response);

                response.close();

            } else {
                LOGGER.info("*** Response: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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

    public String getBaseApiURL() {
        return baseApiURL;
    }

    public void setBaseApiURL(String baseApiURL) {
        this.baseApiURL = baseApiURL;
    }

    public WebTarget getWebTarget() {
        return webTarget;
    }

    public void setWebTarget(WebTarget webTarget) {
        this.webTarget = webTarget;
    }

}
