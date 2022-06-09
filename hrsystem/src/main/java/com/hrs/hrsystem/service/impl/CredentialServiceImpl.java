package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.exception.ResourceNotFoundException;
import com.hrs.hrsystem.model.Credential;
import com.hrs.hrsystem.repository.CredentialRepo;
import com.hrs.hrsystem.service.CredentialService;
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
