package com.sdpsem6.evoting_system.service;

import com.sdpsem6.evoting_system.Models.AddVote;
import com.sdpsem6.evoting_system.Repository.AddVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteCount {

    @Autowired
    public AddVoteRepository addVoteRepository;

    public ResponseEntity<String> AddVote(int id, String partyName){
        System.out.println("Here");
        Optional<AddVote> idInSchema = addVoteRepository.findById(id);
        System.out.println(idInSchema);
        if(idInSchema.isEmpty()){
            AddVote v = new AddVote(id,partyName,1);
            addVoteRepository.save(v);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Thanks for vote");
        }
        AddVote v = addVoteRepository.findById(id).get();
        v.setCount(v.getCount() + 1);
        addVoteRepository.save(v);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Thanks for vote");
    }
}
