package com.example.healthrecordsystemhrs.service;


import com.example.healthrecordsystemhrs.model.Credential;

public interface CredentialService {

    Credential saveCredential(Credential credential);
    Credential updateCredential(Credential credential,long id);
    long idByUserName(String uName);
    Credential updateCredentialByUserName(Credential credential,String uName);
}
