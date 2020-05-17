package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "label",
        "required",
        "nullable",
        "field_type",
        "options"
})
public class ResidentField {

    @JsonProperty("label")
    private String label;
    @JsonProperty("required")
    private String required;
    @JsonProperty("nullable")
    private String nullable;
    @JsonProperty("field_type")
    private String fieldType;
    @JsonProperty("options")
    private List<Option> options = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("required")
    public String getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(String required) {
        this.required = required;
    }

    @JsonProperty("nullable")
    public String getNullable() {
        return nullable;
    }

    @JsonProperty("nullable")
    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    @JsonProperty("field_type")
    public String getFieldType() {
        return fieldType;
    }

    @JsonProperty("field_type")
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    @JsonProperty("options")
    public List<Option> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "title",
            "value"
    })
    public class Option {

        @JsonProperty("title")
        private String title;
        @JsonProperty("value")
        private String value;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("value")
        public String getValue() {
            return value;
        }

        @JsonProperty("value")
        public void setValue(String value) {
            this.value = value;
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
}