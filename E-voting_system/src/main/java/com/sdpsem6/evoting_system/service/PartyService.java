package com.sdpsem6.evoting_system.service;

import com.sdpsem6.evoting_system.Models.Party;
import com.sdpsem6.evoting_system.Repository.PartyRepository;
import com.sdpsem6.evoting_system.helper.FileUploadHelper;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private FileUploadHelper fileUploadHelper;
    public ResponseEntity<String> addParty(MultipartFile file, String name, int id) throws IOException{
        Party party = new Party();
        party.setPartyName(name);
        party.setId(id);
//        party.setPartyLogo(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }
        if(!file.getContentType().equals("image/png")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only PNG content type is allowed");
        }
        boolean f = fileUploadHelper.uploadFile(file);
        if(f){
//            System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
            String pathOfImage = Paths.get(fileUploadHelper.UPLOAD_DIR+File.separator+file.getOriginalFilename()).toString();
            BufferedImage simage = ImageIO.read(new File(pathOfImage));
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ImageIO.write(simage,"png",bytes);
            String srs = Base64.getEncoder().encodeToString(bytes.toByteArray());
            party.setPartyLogo(srs);
            party = partyRepository.insert(party);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Party Successfully Added");
        }
//        BufferedImage simage = ImageIO.read(new File("D:\\React_Java\\SDP_sem-6\\E-voting_system\\src\\main\\resources\\static\\bjp_logo.png"));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
    }

    public Party getParty(int id){
        return partyRepository.findById(id).get();
    }

    public List<Party> getAllParty(){
        return partyRepository.findAll();
    }
}
