package edu.bcm.rds.api.sap.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(namespace = "http://www.w3.org/2005/Atom", localName = "entry")
public class Entry {

    private Author author;
    @JacksonXmlProperty
    private String title;
    @JacksonXmlProperty
    private String updated;
    private Content content;
    @JacksonXmlProperty(isAttribute = true)
    private String xmlns;
    @JacksonXmlProperty
    private String id;

    // Getter Methods

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdated() {
        return updated;
    }

    public Content getContent() {
        return content;
    }

    public String getXmlns() {
        return xmlns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(Author authorObject) {
        this.author = authorObject;
    }

    public void setTitle(String titleObject) {
        this.title = titleObject;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setContent(Content contentObject) {
        this.content = contentObject;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "author=" + author +
                ",\n title='" + title + '\'' +
                ", \nupdated='" + updated + '\'' +
                ",\n content=" + content +
                ",\n xmlns='" + xmlns + '\'' +
                ", \nid='" + id + '\'' +
                '}';
    }
}

