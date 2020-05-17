package edu.bcm.api.taleo.entity;

import java.util.Date;

public class OrientationRecord {

    //Attributes from Candidate
    private String legalFirstName = null;
    private String legalLastName = null;
    private String legalStatus = null;
    private String visaSponsorship = null;
    private String email = null;
    private Date startDate = null;
    private Date hiredDate = null;

    //Attributes from Requisition
    private Integer reqId = -1;
    private String bcmid = null;
    private String bcmDepartment = null;
    private String jobTitle = null;
    private String reqDepartmentalContact = null;
    private Date SAPStartDate = null;

    //Attributes from User (req owner)
    private String requisitionOwnerFirstName = null;

    public String getLegalFirstName() {
        return legalFirstName;
    }

    public void setLegalFirstName(String legalFirstName) {
        this.legalFirstName = legalFirstName;
    }

    public String getLegalLastName() {
        return legalLastName;
    }

    public void setLegalLastName(String legalLastName) {
        this.legalLastName = legalLastName;
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

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getBcmid() {
        return bcmid;
    }

    public void setBcmid(String bcmid) {
        this.bcmid = bcmid;
    }

    public String getRequisitionOwnerFirstName() {
        return requisitionOwnerFirstName;
    }

    public void setRequisitionOwnerFirstName(String requisitionOwnerFirstName) {
        this.requisitionOwnerFirstName = requisitionOwnerFirstName;
    }

    public String getBcmDepartment() {
        return bcmDepartment;
    }

    public void setBcmDepartment(String bcmDepartment) {
        this.bcmDepartment = bcmDepartment;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getReqDepartmentalContact() {
        return reqDepartmentalContact;
    }

    public void setReqDepartmentalContact(String reqDepartmentalContact) {
        this.reqDepartmentalContact = reqDepartmentalContact;
    }

    public Date getSAPStartDate() {
        return SAPStartDate;
    }

    public void setSAPStartDate(Date SAPStartDate) {
        this.SAPStartDate = SAPStartDate;
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

    @Override
    public boolean equals(Object object2) {

        boolean isEqual = false;
        if (object2 == null || !(object2 instanceof OrientationRecord)) {
            return false;
        }

        OrientationRecord orec = (OrientationRecord) object2;

        if (this.email == null || orec.email == null || this.bcmid == null || orec.bcmid == null || this.reqId == null || orec.reqId == null) {
            return false;
        }

        if ((object2 instanceof OrientationRecord) && this.reqId.equals(orec.reqId) && this.bcmid.equals(orec.bcmid)
                && this.email.equalsIgnoreCase(orec.email)) {

            isEqual = true;
        }

        return isEqual;
    }
}
