package edu.bcm.api.taleo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaleoObject implements Serializable {

    private String name = null;
    private String label = null;
    private Boolean searchable = false;
    private Boolean creatable = false;
    private Boolean deletable = false;
    private Map<String, String> urls = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public Boolean getCreatable() {
        return creatable;
    }

    public void setCreatable(Boolean creatable) {
        this.creatable = creatable;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(this.getName()).append(" | Label: ").append(this.getLabel())
                .append(" | Searchable: ").append(this.getSearchable()).append(" | Creatable: ")
                .append(this.getCreatable()).append(" | Deletable: ").append(this.getDeletable())
                .append("\nURLs: [\n");

        Map<String, String> urls = this.getUrls();
        Set<String> keys = urls.keySet();
        Iterator keyIter = keys.iterator();
        while (keyIter.hasNext()) {
            String key = (String) keyIter.next();
            String url = urls.get(key);
            builder.append(key).append(": ").append(url).append("\n");
        }
        builder.append(" ]\n");

        return builder.toString();
    }
}
