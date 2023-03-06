package com.sdpsem6.evoting_system.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vote_Schema")
public class AddVote {
    @Id
    private int id;

    private String partyName;

    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public AddVote(int id, String partyName, int count) {
        this.id = id;
        this.partyName = partyName;
        this.count = count;
    }


}
