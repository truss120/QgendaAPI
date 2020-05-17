
package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "typeID",
        "type_name",
        "visiting_flag"
})
public class ResidentType {

    @JsonProperty("typeID")
    private String typeID;
    @JsonProperty("type_name")
    private String typeName;
    @JsonProperty("visiting_flag")
    private String visitingFlag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("visiting_flag")
    public String getVisitingFlag() {
        return visitingFlag;
    }

    @JsonProperty("visiting_flag")
    public void setVisitingFlag(String visitingFlag) {
        this.visitingFlag = visitingFlag;
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
