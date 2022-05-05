package com.example.healthrecordsystemhrs.repo;

import com.example.healthrecordsystemhrs.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRepo extends JpaRepository<Hospital,Long> {
    // Author --Fahim
    @Query("select hos from Hospital hos where hos.credential.userName=:uName")
    public Hospital HospitalDetailByName(String uName);
}
