package edu.bcm.api.sharepoint.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowSetters = true, allowGetters = true)
public class FlushotAttestation {
    public String fileName;
    public String npi;
    public String name;
    public String firstName;
    public String lastName;
    public String eca;
    public String bcmId;
    public String email;
    public String dept;
    public String deptNumber;
    public String submitDate;
    public String vaccinationYear;
    public String vaccinationDate;
    public String vaccinationRecieved;
    public String vaccinationProvider;
    public String noVaccinationReason;
    public String primaryWorkLocation;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEca() {
        return eca;
    }

    public void setEca(String eca) {
        this.eca = eca;
    }

    public String getBcmId() {
        return bcmId;
    }

    public void setBcmId(String bcmId) {
        this.bcmId = bcmId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getVaccinationYear() {
        return vaccinationYear;
    }

    public void setVaccinationYear(String vaccinationYear) {
        this.vaccinationYear = vaccinationYear;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getVaccinationRecieved() {
        return vaccinationRecieved;
    }

    public void setVaccinationRecieved(String vaccinationRecieved) {
        this.vaccinationRecieved = vaccinationRecieved;
    }

    public String getVaccinationProvider() {
        return vaccinationProvider;
    }

    public void setVaccinationProvider(String vaccinationProvider) {
        this.vaccinationProvider = vaccinationProvider;
    }

    public String getNoVaccinationReason() {
        return noVaccinationReason;
    }

    public void setNoVaccinationReason(String noVaccinationReason) {
        this.noVaccinationReason = noVaccinationReason;
    }

    public String getPrimaryWorkLocation() {
        return primaryWorkLocation;
    }

    public void setPrimaryWorkLocation(String primaryWorkLocation) {
        this.primaryWorkLocation = primaryWorkLocation;
    }
}
