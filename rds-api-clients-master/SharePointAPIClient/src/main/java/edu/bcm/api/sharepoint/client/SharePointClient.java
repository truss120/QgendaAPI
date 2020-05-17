package edu.bcm.api.sharepoint.client;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/*import com.independentsoft.share.File;
import com.independentsoft.share.Service;
import com.independentsoft.share.ServiceException;*/

public class SharePointClient {

    private static final Logger LOGGER = Logger.getLogger(SharePointClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("sharePointClient");

    private Client client = null;
    private String serviceURL = null;
    private WebTarget sharepointWebTarget = null;
    private ObjectMapper objectMapper = null;

    public SharePointClient() {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        try {
            //set default URL values
            this.serviceURL = resourceBundle.getString("SHAREPOINT_BASE_URL");
            sharepointWebTarget = client.target(UriBuilder.fromUri(getServiceURL()).build());
            objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public SharePointClient(String serviceURL, String managerURL) {

        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);

        this.serviceURL = serviceURL;
        sharepointWebTarget = client.target(UriBuilder.fromUri(getServiceURL()).build());
        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    public List<String> listFlushotFile() {
        List<String> results = new ArrayList<String>();

        StringBuilder resultStr = null;
        int totalDatasetSize = 0;

        try {
            Response response =
                    sharepointWebTarget.path("GetFolderByServerRelativeUrl('/DATA_PersonsDataMart_Secondary/')/Files")
                            .request(MediaType.APPLICATION_JSON).get(Response.class);
            LOGGER.info("************ response = " + response);

            if (response != null && response.getStatus() == 200) {
                String responseEntity = response.readEntity(String.class);
                LOGGER.info("************ responseEntity = " + responseEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public static void main(String[] args) {
        SharePointClient client = new SharePointClient();
        client.getFlushotAttestations1();
    }


    public void getFlushotAttestations1() {

        String host = "https://sharepoint.bcm.edu/502/bcm_forms/flu_vaccine_attestation";//resourceBundle.getString("SHAREPOINT_BASE_URL");
        String url = "https://sharepoint.bcm.edu/502/_api/web/lists";

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        NTCredentials credentials = new NTCredentials("svc_edw", "W@r3house", host, "bcm");

        credsProvider.setCredentials(new AuthScope(AuthScope.ANY), credentials);

        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        CloseableHttpResponse response = null;

        try {

            String restUrl = host + resourceBundle.getString("SHAREPOINT_REST_URL");
            HttpGet httpget = new HttpGet(url);

            httpget.addHeader("Accept", "application/json;odata=verbose");
            httpget.addHeader("Content-type", "application/json;odata=verbose");

            System.out.println("*****Executing request " + httpget.getRequestLine());

            response = httpclient.execute(httpget);

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // String responseEntity = EntityUtils.toString(entity, "UTF-8");

                byte[] content = EntityUtils.toByteArray(entity);
                String jsonString = new String(content, "UTF-8");
                System.out.println("#### " + jsonString);
                // JSONObject json = new JSONObject(jsonString);


                System.out.println("*********************************************************************************");
                //    System.out.println(responseEntity);
                System.out.println("*********************************************************************************");

                // parsing JSON
/*                JsonNode jsonNode = this.objectMapper.readValue(responseEntity, JsonNode.class);
                FlushotAttestation flushots = this.objectMapper.readValue(this.objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<FlushotAttestation>>() { });*/

                EntityUtils.consume(response.getEntity());

            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getFlushotAttestations() {
        String host = resourceBundle.getString("SHAREPOINT_BASE_URL");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        NTCredentials credentials = new NTCredentials("svc_edw", "W@r3house", host, "bcm");

        credsProvider.setCredentials(new AuthScope(AuthScope.ANY), credentials);

        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        CloseableHttpResponse response = null;
        try {
            String restUrl = host + resourceBundle.getString("SHAREPOINT_REST_URL");
            HttpGet httpget = new HttpGet(restUrl);

            System.out.println("*****Executing request " + httpget.getRequestLine());
            response = httpclient.execute(httpget);

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());

            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseEntity = EntityUtils.toString(entity, "UTF-8");
                System.out.println("*********************************************************************************");
                //  System.out.println(responseEntity);
                System.out.println("*********************************************************************************");

                // parsing JSON
/*                JsonNode jsonNode = this.objectMapper.readValue(responseEntity, JsonNode.class);
                FlushotAttestation flushots = this.objectMapper.readValue(this.objectMapper.treeAsTokens(jsonNode),
                        new TypeReference<List<FlushotAttestation>>() { });*/

                EntityUtils.consume(response.getEntity());

            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public WebTarget getSharepointWebTarget() {
        return sharepointWebTarget;
    }

    public void setSharepointWebTarget(WebTarget sharepointWebTarget) {
        this.sharepointWebTarget = sharepointWebTarget;
    }

}
