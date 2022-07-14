package com.hrs.service.impl;

import com.hrs.exception.ResourceNotFoundException;
import com.hrs.model.Credential;
import com.hrs.repository.CredentialRepo;
import com.hrs.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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