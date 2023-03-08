package com.sdpsem6.evoting_system.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Voter_List")
public class Voter {
    @Id
    public String adharId;
    @Indexed(unique = true)
    public String voterId;
    public String name;
    public String state;
    @DBRef
    public Constituency constituency;
    public boolean isVoted;

    public String getAdharId() {
        return adharId;
    }

    public void setAdharId(String adharId) {
        this.adharId = adharId;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    public boolean isVoted() {
        return isVoted;
    }

    public void setVoted(boolean voted) {
        isVoted = voted;
    }

    public Voter(String adharId, String voterId, String name, String state, Constituency constituency, boolean isVoted) {
        this.adharId = adharId;
        this.voterId = voterId;
        this.name = name;
        this.state = state;
        this.constituency = constituency;
        this.isVoted = isVoted;
    }

    public Voter() {
    }
}
