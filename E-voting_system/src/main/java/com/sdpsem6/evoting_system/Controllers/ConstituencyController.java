package com.sdpsem6.evoting_system.Controllers;

import com.sdpsem6.evoting_system.Models.Candidate;
import com.sdpsem6.evoting_system.Models.Constituency;
import com.sdpsem6.evoting_system.Models.States;
import com.sdpsem6.evoting_system.Repository.ConstituencyRepository;
import com.sdpsem6.evoting_system.Repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/constituency")
public class ConstituencyController {
    @Autowired
    public ConstituencyRepository constituencyRepository;
    @Autowired
    public StatesRepository statesRepository;
    @PostMapping("/addConstituency")
    public ResponseEntity<?> addConstituency(@RequestBody Constituency constituency) {

        if (constituency != null) {
            String st = constituency.getState().getStateName();
            States state = statesRepository.findStatesByStateName(st);
            constituency.setState(state);
            constituencyRepository.save(constituency);
            return ResponseEntity.ok(constituency);
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("Null value not allowed");
    }
//    @CrossOrigin(origins = "http://localhost:3000",methods = RequestMethod.GET)
    @GetMapping("/getConstituencyListFromState/{state}")
    public List<Constituency> GetConstituencyListFromState(@PathVariable("state") String state){
        States st = statesRepository.findStatesByStateName(state);
//        System.out.println("here");
        return constituencyRepository.getConstituenciesByState(st);
    }
}