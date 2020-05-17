package edu.bcm.api.cms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CmsSearchResult implements Serializable {

    private CmsGeneralObject cmsGeneralObject = null;
    private CmsResearchObject cmsResearchObject = null;
    private CmsOwnershipObject cmsOwnershipObject = null;

    public CmsGeneralObject getCmsGeneralObject() {
        return cmsGeneralObject;
    }

    public void setCmsGeneralObject(CmsGeneralObject cmsGeneralObject) {
        this.cmsGeneralObject = cmsGeneralObject;
    }

    public CmsResearchObject getCmsResearchObject() {
        return cmsResearchObject;
    }

    public void setCmsResearchObject(CmsResearchObject cmsResearchObject) {
        this.cmsResearchObject = cmsResearchObject;
    }

    public CmsOwnershipObject getCmsOwnershipObject() {
        return cmsOwnershipObject;
    }

    public void setCmsOwnershipObject(CmsOwnershipObject cmsOwnershipObject) {
        this.cmsOwnershipObject = cmsOwnershipObject;
    }
}
