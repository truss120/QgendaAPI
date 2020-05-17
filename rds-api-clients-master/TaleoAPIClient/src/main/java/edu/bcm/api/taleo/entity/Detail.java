package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail implements Serializable {

    private Map<String, String> details;

    public Map<String, String> getValues() {
        return details;
    }

    public void setValues(Map<String, String> values) {
        this.details = values;
    }
}
