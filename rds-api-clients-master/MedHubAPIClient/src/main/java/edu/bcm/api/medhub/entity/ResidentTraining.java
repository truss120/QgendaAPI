package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "trainingID",
        "training_typeID",
        "training_type_name",
        "star t_date",
        "end_date",
        "level",
        "programID",
        "program_name",
        "inhouse",
        "locat ion",
        "typeID",
        "type_name"
})
public class ResidentTraining {

    @JsonProperty("trainingID")
    private String trainingID;
    @JsonProperty("training_typeID")
    private String trainingTypeID;
    @JsonProperty("training_type_name")
    private String trainingTypeName;
    @JsonProperty("star t_date")
    private String starTDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("level")
    private String level;
    @JsonProperty("programID")
    private String programID;
    @JsonProperty("program_name")
    private String programName;
    @JsonProperty("inhouse")
    private Boolean inhouse;
    @JsonProperty("locat ion")
    private String locatIon;
    @JsonProperty("typeID")
    private String typeID;
    @JsonProperty("type_name")
    private String typeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("trainingID")
    public String getTrainingID() {
        return trainingID;
    }

    @JsonProperty("trainingID")
    public void setTrainingID(String trainingID) {
        this.trainingID = trainingID;
    }

    @JsonProperty("training_typeID")
    public String getTrainingTypeID() {
        return trainingTypeID;
    }

    @JsonProperty("training_typeID")
    public void setTrainingTypeID(String trainingTypeID) {
        this.trainingTypeID = trainingTypeID;
    }

    @JsonProperty("training_type_name")
    public String getTrainingTypeName() {
        return trainingTypeName;
    }

    @JsonProperty("training_type_name")
    public void setTrainingTypeName(String trainingTypeName) {
        this.trainingTypeName = trainingTypeName;
    }

    @JsonProperty("star t_date")
    public String getStarTDate() {
        return starTDate;
    }

    @JsonProperty("star t_date")
    public void setStarTDate(String starTDate) {
        this.starTDate = starTDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    @JsonProperty("program_name")
    public String getProgramName() {
        return programName;
    }

    @JsonProperty("program_name")
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @JsonProperty("inhouse")
    public Boolean getInhouse() {
        return inhouse;
    }

    @JsonProperty("inhouse")
    public void setInhouse(Boolean inhouse) {
        this.inhouse = inhouse;
    }

    @JsonProperty("locat ion")
    public String getLocatIon() {
        return locatIon;
    }

    @JsonProperty("locat ion")
    public void setLocatIon(String locatIon) {
        this.locatIon = locatIon;
    }

    @JsonProperty("typeID")
    public String getTypeID() {
        return typeID;
    }

    @JsonProperty("typeID")
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @JsonProperty("type_name")
    public String getTypeName() {
        return typeName;
    }

    @JsonProperty("type_name")
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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