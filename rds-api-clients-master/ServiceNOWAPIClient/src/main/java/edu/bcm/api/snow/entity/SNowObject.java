package edu.bcm.api.snow.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SNowObject {

    @JsonProperty("sys_mod_count")
    private String sysModCount;
    @JsonProperty("sys_tags")
    private String sysTags;
    @JsonProperty("sys_updated_on")
    private String sysUpdatedOn;
    @JsonProperty("sys_updated_by")
    private String sysUpdatedBy;
    @JsonProperty("sys_created_on")
    private String sysCreatedOn;
    @JsonProperty("sys_created_by")
    private String sysCreatedBy;
    @JsonProperty("sys_id")
    private String sysId;

    @JsonProperty("sys_updated_on")
    public String getSysUpdatedOn() {
        return sysUpdatedOn;
    }

    @JsonProperty("sys_updated_on")
    public void setSysUpdatedOn(String sysUpdatedOn) {
        this.sysUpdatedOn = sysUpdatedOn;
    }

    @JsonProperty("sys_updated_by")
    public String getSysUpdatedBy() {
        return sysUpdatedBy;
    }

    @JsonProperty("sys_updated_by")
    public void setSysUpdatedBy(String sysUpdatedBy) {
        this.sysUpdatedBy = sysUpdatedBy;
    }


    @JsonProperty("sys_created_on")
    public String getSysCreatedOn() {
        return sysCreatedOn;
    }

    @JsonProperty("sys_created_on")
    public void setSysCreatedOn(String sysCreatedOn) {
        this.sysCreatedOn = sysCreatedOn;
    }

    @JsonProperty("sys_created_by")
    public String getSysCreatedBy() {
        return sysCreatedBy;
    }

    @JsonProperty("sys_created_by")
    public void setSysCreatedBy(String sysCreatedBy) {
        this.sysCreatedBy = sysCreatedBy;
    }

    @JsonProperty("sys_id")
    public String getSysId() {
        return sysId;
    }

    @JsonProperty("sys_id")
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    @JsonProperty("sys_mod_count")
    public String getSysModCount() {
        return sysModCount;
    }

    @JsonProperty("sys_mod_count")
    public void setSysModCount(String sysModCount) {
        this.sysModCount = sysModCount;
    }

    @JsonProperty("sys_tags")
    public String getSysTags() {
        return sysTags;
    }

    @JsonProperty("sys_tags")
    public void setSysTags(String sysTags) {
        this.sysTags = sysTags;
    }

}

