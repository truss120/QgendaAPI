package edu.bcm.api.snow.entity;

import java.util.ArrayList;
import java.util.List;

public class SNOWResponse {
    private List<SGARequest> result = new ArrayList<SGARequest>();

    public List<SGARequest> getResult() {
        return result;
    }

    public void setResult(List<SGARequest> result) {
        this.result = result;
    }
}
