package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userID",
        "name_last",
        "name_first",
        "email",
        "username",
        "employeeID",
        "typeID",
        "level",
        "programID"
})
public class ResidentSummary {

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
    @JsonProperty("typeID")
    private String typeID;
    @JsonProperty("level")
    private String level;
    @JsonProperty("programID")
    private String programID;
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

    @JsonProperty("typeID")
    public String getTypeID() {
        return typeID;
    }

    @JsonProperty("typeID")
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("programID")
    public String getProgramID() {
        return programID;
    }

    @JsonProperty("programID")
    public void setProgramID(String programID) {
        this.programID = programID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        String mainProps = "ResidentSummary{" +
                "userID='" + userID + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", typeID='" + typeID + '\'' +
                ", level='" + level + '\'' +
                ", programID='" + programID + '\'' +
                ", additionalProperties={";
        StringBuilder sb = new StringBuilder();
        sb.append(mainProps);

        Set keys = this.additionalProperties.keySet();
        for (Object key : keys) {
            sb.append("'").append(key).append(" = '").append(this.additionalProperties.get(key)).append("', ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}").append(" }");

        return sb.toString();
    }
}
