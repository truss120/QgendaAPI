package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "programID",
        "program_name",
        "program_abbrev",
        "program_level",
        "dept_programID"
})
public class Program {

    @JsonProperty("programID")
    private String programID;
    @JsonProperty("program_name")
    private String programName;
    @JsonProperty("program_abbrev")
    private String programAbbrev;
    @JsonProperty("program_level")
    private String programLevel;
    @JsonProperty("dept_programID")
    private String deptProgramID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("program_abbrev")
    public String getProgramAbbrev() {
        return programAbbrev;
    }

    @JsonProperty("program_abbrev")
    public void setProgramAbbrev(String programAbbrev) {
        this.programAbbrev = programAbbrev;
    }

    @JsonProperty("program_level")
    public String getProgramLevel() {
        return programLevel;
    }

    @JsonProperty("program_level")
    public void setProgramLevel(String programLevel) {
        this.programLevel = programLevel;
    }

    @JsonProperty("dept_programID")
    public String getDeptProgramID() {
        return deptProgramID;
    }

    @JsonProperty("dept_programID")
    public void setDeptProgramID(String deptProgramID) {
        this.deptProgramID = deptProgramID;
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