package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Requisition implements Serializable {

    private Integer reqId = -1;
    private String bcmid = null;
    private String lastName = null;
    private String bcmDepartment = null;
    private Integer department = null;
    private String sapDepartment = null;
    private String title = null;
    private String reqDepartmentalContact = null;
    private Date SAPStartDate = null;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBcmDepartment() {
        return bcmDepartment;
    }

    public void setBcmDepartment(String bcmDepartment) {
        this.bcmDepartment = bcmDepartment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSapDepartment() {
        return sapDepartment;
    }

    public void setSapDepartment(String sapDepartment) {
        this.sapDepartment = sapDepartment;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("ReqID: ").append(this.getReqId())
                .append(" | BcmID: ").append(this.getBcmid())
                .append(" | BcmDepartment: ").append(this.getBcmDepartment())
                .append(" | Title: ").append(this.getTitle())
                .append(" | SAPStartDate: ").append(this.getSAPStartDate())
                .append(" | Department Contact: ").append(this.getReqDepartmentalContact());
        builder.append(" ]\n");

        return builder.toString();
    }
}
