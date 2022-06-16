package com.hrs.hrsystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file) throws IOException {
       // System.out.println(file.getOriginalFilename());
        file.transferTo(new File("C:\\soft\\"+file.getOriginalFilename()));
        return file.getOriginalFilename();
    }
}
