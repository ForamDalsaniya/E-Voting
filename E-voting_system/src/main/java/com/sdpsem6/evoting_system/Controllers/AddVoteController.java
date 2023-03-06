package com.sdpsem6.evoting_system.Controllers;

import com.sdpsem6.evoting_system.Models.AddVote;
import com.sdpsem6.evoting_system.service.VoteCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/vote")
public class AddVoteController {
    @Autowired
    public VoteCount voteCount;

    @PutMapping("/voteCount")
    public ResponseEntity<String> addVote(@RequestBody AddVote addVote){
//        int t = Integer.parseInt(id);
        int id = addVote.getId();
        String p = addVote.getPartyName();
//    public ResponseEntity<String> addVote(@RequestParam("id") int id, @RequestParam("partyName") String partyName){
        return voteCount.AddVote(id,p);
    }
}
