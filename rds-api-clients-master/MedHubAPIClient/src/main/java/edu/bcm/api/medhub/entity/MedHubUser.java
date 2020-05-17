package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userID",
        "name_last",
        "name_first",
        "email",
        "username",
        "employeeID",
        "user_type",
        "user_type_name",
        "programID",
        "program_name",
        "resident_typeID",
        "resident_level",
        "status",
        "status_name",
        "access",
        "access_name"
})
public class MedHubUser {

    @JsonProperty("userID")
    private String userID;
    @JsonProperty("name_last")
    private String nameLast;
    @JsonProperty("name_first")
    private String nameFirst;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("employeeID")
    private String employeeID;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("user_type_name")
    private String userTypeName;
    @JsonProperty("programID")
    private String programID;
    @JsonProperty("program_name")
    private String programName;
    @JsonProperty("resident_typeID")
    private String residentTypeID;
    @JsonProperty("resident_level")
    private String residentLevel;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_name")
    private String statusName;
    @JsonProperty("access")
    private String access;
    @JsonProperty("access_name")
    private String accessName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userID")
    public String getUserID() {
        return userID;
    }

    @JsonProperty("userID")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty("name_last")
    public String getNameLast() {
        return nameLast;
    }

    @JsonProperty("name_last")
    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    @JsonProperty("name_first")
    public String getNameFirst() {
        return nameFirst;
    }

    @JsonProperty("name_first")
    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("employeeID")
    public String getEmployeeID() {
        return employeeID;
    }

    @JsonProperty("employeeID")
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @JsonProperty("user_type")
    public String getUseRType() {
        return userType;
    }

    @JsonProperty("user_type")
    public void setUseRType(String useRType) {
        this.userType = useRType;
    }

    @JsonProperty("user_type_name")
    public String getUserTypeName() {
        return userTypeName;
    }

    @JsonProperty("user_type_name")
    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @JsonProperty("programID")
    public String getProgramID() {
        return programID;
    }

    @JsonProperty("programID")
    public void setProgramID(String programID) {
        this.programID = programID;
    }

    @JsonProperty("program_name")
    public String getProgramName() {
        return programName;
    }

    @JsonProperty("program_name")
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @JsonProperty("resident_typeID")
    public String getResidentTypeID() {
        return residentTypeID;
    }

    @JsonProperty("resident_typeID")
    public void setResidentTypeID(String residentTypeID) {
        this.residentTypeID = residentTypeID;
    }

    @JsonProperty("resident_level")
    public String getResidentLevel() {
        return residentLevel;
    }

    @JsonProperty("resident_level")
    public void setResidentLevel(String residentLevel) {
        this.residentLevel = residentLevel;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("status_name")
    public String getStatusName() {
        return statusName;
    }

    @JsonProperty("status_name")
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @JsonProperty("access")
    public String getAccess() {
        return access;
    }

    @JsonProperty("access")
    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty("access_name")
    public String getAccessName() {
        return accessName;
    }

    @JsonProperty("access_name")
    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
