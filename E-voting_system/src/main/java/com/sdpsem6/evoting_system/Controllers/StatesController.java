package com.sdpsem6.evoting_system.Controllers;

import com.sdpsem6.evoting_system.Models.Candidate;
import com.sdpsem6.evoting_system.Models.States;
import com.sdpsem6.evoting_system.Repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.sdpsem6.evoting_system.dto.stateCandidateDto;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/states")
public class StatesController {

    @Autowired
    private StatesRepository statesRepository;
    @PostMapping("/addState")
    public ResponseEntity<String> addState(@RequestBody States state){
        if(state != null){
            statesRepository.save(state);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("States added successfully!!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
    }
    @GetMapping("/getAllStates")
    public List<States> getAllStates(){
        List<States> states = statesRepository.findAll();
        return states;
    }


}
