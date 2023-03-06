package com.sdpsem6.evoting_system.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "D:\\SDP_sem-6\\E-voting_system\\src\\main\\resources\\static\\images";
    public FileUploadHelper() throws IOException{

    }
    public boolean uploadFile(MultipartFile multipartFile){
        boolean f = false;
        try{
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
