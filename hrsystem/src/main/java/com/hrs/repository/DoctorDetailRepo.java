package com.hrs.repository;

import com.hrs.model.DoctorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorDetailRepo extends JpaRepository<DoctorDetail,Long> {
    @Query("select doctor from DoctorDetail doctor where doctor.credential.userName=:uName")
    public DoctorDetail userDetailByName(String uName);
}
