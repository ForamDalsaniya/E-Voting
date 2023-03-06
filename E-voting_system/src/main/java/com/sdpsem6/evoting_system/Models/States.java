package com.sdpsem6.evoting_system.Models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "States")
public class States {
    @Id
    @Indexed(unique = true)
    public ObjectId id;
    public String stateName;

    public States(String stateName) {
        this.stateName = stateName;
    }

    public States() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "States{" +
                "id=" + id +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
