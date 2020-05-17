package edu.bcm.rds.api.sap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SAPResponse implements Serializable {

    private String logonToken = null;

}
