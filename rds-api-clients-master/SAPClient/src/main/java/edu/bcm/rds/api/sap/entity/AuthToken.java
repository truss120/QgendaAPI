package edu.bcm.rds.api.sap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.ws.rs.core.Cookie;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthToken implements Serializable {

    private String token = null;
    private Cookie authCookie = new Cookie("authToken", token);

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Cookie getAuthCookie() {
        return authCookie;
    }

    public void setAuthCookie(Cookie authCookie) {
        this.authCookie = authCookie;
    }


    Attrs AttrsObject;
    private String _type;


    // Getter Methods

    public Attrs getAttrs() {
        return AttrsObject;
    }

    public String get_type() {
        return _type;
    }

    // Setter Methods

    public void setAttrs(Attrs attrsObject) {
        this.AttrsObject = attrsObject;
    }

    public void set_type(String _type) {
        this._type = _type;
    }
}
