package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.Credential;
import com.example.healthrecordsystemhrs.service.impl.CredentialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Author --Fahim
@RestController
@RequestMapping("/credential")
public class CredentialControll {

    @Autowired
    private CredentialServiceImpl credentialService;

    @PutMapping("/{id}")
    public ResponseEntity<Credential> updateCredential(@RequestBody Credential credential, @PathVariable long id){
        return new ResponseEntity<Credential>(credentialService.updateCredential(credential,id), HttpStatus.OK);
    }

    @PutMapping("/userName/{uName}")
    public ResponseEntity<Credential> updateCredentialByUserName(@RequestBody Credential credential,@PathVariable String uName){
        return new ResponseEntity<Credential>(credentialService.updateCredentialByUserName(credential,uName),HttpStatus.OK);
    }
    @PostMapping({"/createNewRole"})
    public Credential createNewRole(@RequestBody Credential credential){
        return credentialService.saveCredential(credential);
    }
}
