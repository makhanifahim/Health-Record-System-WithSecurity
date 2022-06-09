package com.hrs.hrsystem.service;


import com.hrs.hrsystem.model.Credential;

public interface CredentialService {

    Credential saveCredential(Credential credential);
    Credential updateCredential(Credential credential,long id);
    long idByUserName(String uName);
    Credential updateCredentialByUserName(Credential credential,String uName);
}
