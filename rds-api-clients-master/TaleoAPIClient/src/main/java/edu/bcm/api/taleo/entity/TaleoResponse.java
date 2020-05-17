package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaleoResponse implements Serializable {

    private TaleoResponseDetail response = null;
    private Status status = null;

    public TaleoResponseDetail getResponse() {
        return response;
    }

    public void setResponse(TaleoResponseDetail response) {
        this.response = response;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
