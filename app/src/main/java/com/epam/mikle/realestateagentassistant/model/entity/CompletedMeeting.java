package com.epam.mikle.realestateagentassistant.model.entity;


import java.io.Serializable;

public class CompletedMeeting extends Meeting {
    private String results;

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
