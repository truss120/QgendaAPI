package edu.bcm.rds.api.sap.entity;

import javax.xml.bind.annotation.XmlElement;

public class Author {

    @XmlElement
    private String name;
    @XmlElement
    private String uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}