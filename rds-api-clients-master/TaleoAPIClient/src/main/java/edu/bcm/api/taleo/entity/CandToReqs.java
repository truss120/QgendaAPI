package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CandToReqs implements Serializable {

    private CandidateApplication candidateApplication = null;

    public CandidateApplication getCandidateApplication() {
        return candidateApplication;
    }

    public void setCandidateApplication(CandidateApplication candidateApplication) {
        this.candidateApplication = candidateApplication;
    }
}
