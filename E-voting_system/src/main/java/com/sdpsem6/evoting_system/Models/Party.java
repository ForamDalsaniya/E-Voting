package com.sdpsem6.evoting_system.Models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;


@Document(collection = "Party")
public class Party {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Id

    private int id ;
    private String partyName;


    private String partyLogo;
//    private Binary partyLogo;

    public Party(){

    }

    public Party(int id,String partyName, String partyLogo) {
        this.partyName = partyName;
        this.id = id;
        this.partyLogo = partyLogo;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyLogo() {
        return partyLogo;
    }

    public void setPartyLogo(String partyLogo) {
        this.partyLogo = partyLogo;
    }
}
