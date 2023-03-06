package com.sdpsem6.evoting_system.Controllers;

import com.sdpsem6.evoting_system.Models.Party;
import com.sdpsem6.evoting_system.Repository.PartyRepository;
import com.sdpsem6.evoting_system.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;

//    @RequestMapping(value = "/addParty", headers = "Content-Type=multipart/*",method = RequestMethod.POST)
    @PostMapping("/addParty/{partyName}/{id}")
    public ResponseEntity<String> addParty(@RequestParam("partyLogo")MultipartFile file, @PathVariable("partyName") String name, @PathVariable("id") int id) throws IOException {
//        System.out.println(file.getOriginalFilename())
        return partyService.addParty(file,name,id);
    }
    @GetMapping("getParty/{id}")
    public Party getParty(@PathVariable("id") int id){
        Party party = partyService.getParty(id);
//        model.addAttribute("image",
//        Base64.getEncoder().encodeToString(party.getPartyLogo().getData());
        return party;
    }
    @GetMapping("getAllParty")
    public List<Party> getAllParty(){
        return partyService.getAllParty();
    }
}
