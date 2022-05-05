package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CredentialRepo extends JpaRepository<Credential,Long> {
    // Author --Fahim
    @Query("select cred.credentialId from Credential cred where cred.userName=:uName")
    public long idByUserName(String uName);

    @Query(value = "select * from credential where user_name = ?1",nativeQuery = true)
    Credential findusername(String emailid);
}
