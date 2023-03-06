package com.sdpsem6.evoting_system.Controllers;

import com.sdpsem6.evoting_system.Models.Candidate;
import com.sdpsem6.evoting_system.Models.Party;
import com.sdpsem6.evoting_system.Repository.CandidateRepository;
import com.sdpsem6.evoting_system.Repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PartyRepository partyRepository;
    @PostMapping("/addCandidate")
    public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate){
        System.out.println("In candidate");
        if(candidate.getAdharId().length() != 12){
            System.out.println("Invalid adhar id");
//            error
//            return ResponseEntity.status(HttpStatusCode.valueOf(40))
        }
//        if(candidate.getAdharId() == null)
//            System.out.println("Null");
        Candidate cnd = this.candidateRepository.save(candidate);
        return ResponseEntity.ok(cnd);
    }
    @GetMapping("/getAllCandidate")
    public List<Candidate> getCandidate(){
        return this.candidateRepository.findAll();
    }

    @GetMapping("/getAllParty")
    public List<Party> getParty(){
        return this.partyRepository.findAll();
    }

    @GetMapping("/getCandidate/{stateName}/{constituency}")
//    @GetMapping("/getCandidate")
    public List<Candidate> getCandidateByStateName(@PathVariable("stateName") String stateName, @PathVariable("constituency") String constituency){
//    public List<Candidate> getCandidateByStateName(@RequestBody ConstituencyState cs){
        List<Candidate> lst = candidateRepository.findAllByStateAndConstituency(stateName,constituency);
        System.out.println(lst.size());
        return candidateRepository.findAllByStateAndConstituency(stateName,constituency);
    }
}
