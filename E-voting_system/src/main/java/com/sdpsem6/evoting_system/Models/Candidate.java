package com.sdpsem6.evoting_system.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

@Document(collection = "Candidate_Info")
public class Candidate {
    @Id
    private String adharId;
    private String name;
    private String city;
    private long mobileNo;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dob = new Date();
    private String constituency;

    private String state;
//    private String party;
    @DBRef
    private Party party;
    public String getAdharId() {
        return adharId;
    }

    public void setAdharId(String adharId) {
        this.adharId = adharId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Candidate() {
    }

    public Candidate(String adharId, String name, String city, long mobileNo, Date dob, String constituency, String state, Party party) {
        this.adharId = adharId;
        this.name = name;
        this.city = city;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.constituency = constituency;
        this.state = state;
        this.party = party;
    }
}
