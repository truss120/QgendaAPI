package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaleoResponseDetail implements Serializable {

    private String URL = null;
    private String authToken = null;
    private Status status = null;
    private List<TaleoObject> objects = null;
    private Candidate candidate = null;
    private Requisition requisition = null;
    private User user = null;
    private List<SearchResults> searchResults = null;
    private List<CandToReqs> candToReqs = null;
    private List<RequisitionOwner> owners = null;
    private Department department = null;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<TaleoObject> getObjects() {
        return objects;
    }

    public void setObjects(List<TaleoObject> objects) {
        this.objects = objects;
    }

    public List<SearchResults> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResults> searchResults) {
        this.searchResults = searchResults;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CandToReqs> getCandToReqs() {
        return candToReqs;
    }

    public void setCandToReqs(List<CandToReqs> candToReqs) {
        this.candToReqs = candToReqs;
    }

    public List<RequisitionOwner> getOwners() {
        return owners;
    }

    public void setOwners(List<RequisitionOwner> owners) {
        this.owners = owners;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
