package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Candidate implements Serializable {

    private String firstName = null;
    private String lastName = null;
    private String legalStatus = null;
    private String visaSponsorship = null;
    private String email = null;
    private Date startDate = null;
    private Date hiredDate = null;
    private Integer status = null;

    public Candidate() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getVisaSponsorship() {
        return visaSponsorship;
    }

    public void setVisaSponsorship(String visaSponsorship) {
        this.visaSponsorship = visaSponsorship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("FirstName: ").append(this.getFirstName())
                .append(" | LastName: ").append(this.getLastName())
                .append(" | LegalStatus: ").append(this.getLegalStatus())
                .append(" | VisaSponsorship: ").append(this.getVisaSponsorship())
                .append(" | Email: ").append(this.getEmail())
                .append(" | Hired Date: ").append(this.getHiredDate())
                .append(" | Start Date: ").append(this.getStartDate());
        builder.append(" ]\n");

        return builder.toString();
    }
}
