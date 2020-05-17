package edu.bcm.api.cms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CmsResponse implements Serializable {

    private List<CmsGeneralObject> generalObjectsobjects = null;
    private List<CmsResearchObject> researchObjects = null;
    private List<CmsOwnershipObject> ownershipObjects = null;
    private List<CmsObject> objects = null;

    public List<CmsGeneralObject> getGeneralObjectsobjects() {
        return generalObjectsobjects;
    }

    public void setGeneralObjectsobjects(List<CmsGeneralObject> generalObjectsobjects) {
        this.generalObjectsobjects = generalObjectsobjects;
    }

    public List<CmsResearchObject> getResearchObjects() {
        return researchObjects;
    }

    public void setResearchObjects(List<CmsResearchObject> researchObjects) {
        this.researchObjects = researchObjects;
    }

    public List<CmsOwnershipObject> getOwnershipObjects() {
        return ownershipObjects;
    }

    public void setOwnershipObjects(List<CmsOwnershipObject> ownershipObjects) {
        this.ownershipObjects = ownershipObjects;
    }

    public List<CmsObject> getObjects() {
        return objects;
    }

    public void setObjects(List<CmsObject> objects) {
        this.objects = objects;
    }
}
