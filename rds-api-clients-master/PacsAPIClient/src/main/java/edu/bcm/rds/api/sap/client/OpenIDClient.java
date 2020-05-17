package edu.bcm.rds.api.sap.client;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.TokenVerifier;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * OpenID client
 *
 * @author <a href="nmajorov@redhat.com">Nikolaj Majorov</a>
 */
public class OpenIDClient {

    private static final Logger LOG = Logger.getLogger(OpenIDClient.class.getName());
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("pacsClient");

    protected MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl<String, String>();
    private static String ACCEPT = "multipart/related";
    private static String CONTENT_TYPE = "application/dicom";

    private String serverUrl;

    private String realmId;

    private String clientId = "";
    private String clientSecret = null;

    private ResteasyClient client = null;
    private String serviceURL = null;
    private String tokenURL = null;
    private ResteasyWebTarget webTarget = null;
    private ObjectMapper objectMapper = null;

    public OpenIDClient() {

        this.serverUrl = resourceBundle.getString("KEYCLOAK_SERVER_URL");
        this.realmId = resourceBundle.getString("KEYCLOAK_REALM_ID");
        this.clientId = resourceBundle.getString("KEYCLOAK_CLIENT_ID");
        this.clientSecret = resourceBundle.getString("KEYCLOAK_CLIENT_SECRET");

        //set default URL values
        this.serviceURL = resourceBundle.getString("BASE_PACS_REST_URL");
        this.tokenURL = resourceBundle.getString("KEYCLOAK_TOKEN_URL");
        this.clientSecret = resourceBundle.getString("KEYCLOAK_CLIENT_SECRET");

        client = new ResteasyClientBuilder().build();
        webTarget = client.target(UriBuilder.fromPath(getServiceURL()));

        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    public AccessToken getAccessToken(String username, String password) {
        try {

            KeycloakBuilder keycloakBuilder = KeycloakBuilder.builder()
                    .realm(realmId)
                    .serverUrl(serverUrl)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .grantType(OAuth2Constants.CLIENT_CREDENTIALS);

            //    keycloakBuilder.username(username).password(password).grantType(OAuth2Constants.PASSWORD);

            Keycloak keycloak = keycloakBuilder.build();

            AccessTokenResponse tokenResponse = keycloak.tokenManager().getAccessToken();
            AccessToken accessToken = TokenVerifier.create(tokenResponse.getToken(), AccessToken.class).getToken();
            LOG.info("**** Token: " + accessToken.getPreferredUsername());

            return accessToken;

        } catch (VerificationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getAccessToken() {
        try {

            KeycloakBuilder keycloakBuilder = KeycloakBuilder.builder()
                    .realm(realmId)
                    .serverUrl(serverUrl)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .grantType(OAuth2Constants.CLIENT_CREDENTIALS);


            Keycloak keycloak = keycloakBuilder.build();

            AccessTokenResponse tokenResponse = keycloak.tokenManager().getAccessToken();
            String token = tokenResponse.getToken();
            //   LOG.info("**** Token: " + token);

            return token;

        } catch (Exception e) {

            LOG.severe(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public ResteasyClient getClient() {
        return client;
    }

    public void setClient(ResteasyClient client) {
        this.client = client;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public String getTokenURL() {
        return tokenURL;
    }

    public void setTokenURL(String tokenURL) {
        this.tokenURL = tokenURL;
    }

    public ResteasyWebTarget getWebTarget() {
        return webTarget;
    }

    public void setWebTarget(ResteasyWebTarget webTarget) {
        this.webTarget = webTarget;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}