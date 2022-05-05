package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.DoctorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorDetailRepo extends JpaRepository<DoctorDetail,Long> {
    // Author --Fahim
    @Query("select doctor from DoctorDetail doctor where doctor.credential.userName=:uName")
    public DoctorDetail userDetailByName(String uName);
}
