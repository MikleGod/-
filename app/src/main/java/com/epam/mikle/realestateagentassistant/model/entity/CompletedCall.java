package com.epam.mikle.realestateagentassistant.model.entity;

import java.io.Serializable;



public class CompletedCall extends Call{
    private String results;
    private String callDuration;

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
