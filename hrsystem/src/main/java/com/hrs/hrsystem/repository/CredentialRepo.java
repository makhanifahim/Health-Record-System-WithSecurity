package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CredentialRepo extends JpaRepository<Credential,Long> {

    @Query("select cred.credentialId from Credential cred where cred.userName=:uName")
    public long idByUserName(String uName);

    @Query("select cred from Credential cred where cred.userName=:uName")
    public Credential findusername(String uName);
}
