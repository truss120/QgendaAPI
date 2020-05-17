package edu.bcm.api.medhub.entity;

import java.io.Serializable;
import java.util.List;

public class MedhubResponse implements Serializable {

    private MedhubResponse response = null;
    private List<MedHubResident> objects = null;
    private String authToken = null;


    public MedhubResponse getResponse() {
        return response;
    }

    public void setResponse(MedhubResponse response) {
        this.response = response;
    }

    public List<MedHubResident> getObjects() {
        return objects;
    }

    public String getAuthToken() {
        return authToken;
    }
}
