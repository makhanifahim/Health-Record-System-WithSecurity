package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.exception.ResourceNotFoundException;
import com.example.healthrecordsystemhrs.model.Credential;
import com.example.healthrecordsystemhrs.repo.CredentialRepo;
import com.example.healthrecordsystemhrs.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Author --Fahim
@Service
public class CredentialServiceImpl implements CredentialService {
    @Autowired
    private CredentialRepo credentialRepo;

    @Override
    public Credential saveCredential(Credential credential) {
        return credentialRepo.save(credential);
    }

    @Override
    public Credential updateCredential(Credential credential,long id) {
        //long id =credentialRepo.getCredentialId(credential.getUserName());
        Credential existingcredential = credentialRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Credential","id",id));
        existingcredential.setPassWord(credential.getPassWord());
        credentialRepo.save(existingcredential);
        return existingcredential;
    }

    @Override
    public long idByUserName(String uName) {
        return credentialRepo.idByUserName(uName);
    }

    @Override
    public Credential updateCredentialByUserName(Credential credential, String uName) {
        long id = (long) credentialRepo.idByUserName(uName);
        Credential existingcredential = credentialRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Credential","id",id));
        existingcredential.setPassWord(credential.getPassWord());
        credentialRepo.save(existingcredential);
        return existingcredential;
    }


}
