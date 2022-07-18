package com.hrs.controller;

import com.hrs.EmailSenderService;
import com.hrs.model.Credential;
import com.hrs.service.impl.CredentialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/credential")
public class CredentialController {
    int GeneratedOTP;
    @Autowired
    private CredentialServiceImpl credentialService;

    @Autowired
    private EmailSenderService service;


    @PutMapping("/{id}")
    public ResponseEntity<Credential> updateCredential(@RequestBody Credential credential, @PathVariable long id){
        return new ResponseEntity<Credential>(credentialService.updateCredential(credential,id), HttpStatus.OK);
    }
    @PostMapping("/OTP/{uName}")
    public void OTP(@PathVariable String uName){
        GeneratedOTP=(int) (Math.random()*(100000-157)+110)+130;
        service.sendSimpleEmail(uName,Integer.toString(GeneratedOTP),"OTP from Health Record System ");
        System.out.println(GeneratedOTP);
    }
    @PutMapping("/reset/{uName}/{OTPS}")
    public int updateCredentialByUserName(@RequestBody Credential credential,@PathVariable String uName,@PathVariable int OTPS){
        if (OTPS==GeneratedOTP){
            credentialService.updateCredentialByUserName(credential,uName);
            return 1;
        }
        else{
            return 0;
        }
    }
    @PostMapping({"/createNewRole"})
    public Credential createNewRole(@RequestBody Credential credential){
        return credentialService.saveCredential(credential);
    }
}
