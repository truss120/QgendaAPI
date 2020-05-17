package edu.bcm.rds.api.sap.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class Attrs {

    private ArrayList<Attr> attrs = new ArrayList<Attr>();
    @JacksonXmlProperty
    private Attr attr;
    @JacksonXmlProperty(isAttribute = true)
    private String xmlns;

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public ArrayList<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(ArrayList<Attr> attrList) {
        this.attrs = attrList;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @Override
    public String toString() {
        return "Attrs{" +
                "attrs=" + attrs +
                ", attr=" + attr +
                ", xmlns='" + xmlns + '\'' +
                '}';
    }
}