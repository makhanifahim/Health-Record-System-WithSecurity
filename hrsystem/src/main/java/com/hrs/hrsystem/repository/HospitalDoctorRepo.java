package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.DoctorDetail;
import com.hrs.hrsystem.model.Hospital;
import com.hrs.hrsystem.model.HospitalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalDoctorRepo extends JpaRepository<HospitalDoctor,Long> {
    // Author
    @Query("select hds.doctorDetail from HospitalDoctor hds where hds.hospital.hospitalId=:id")
    public List<DoctorDetail> listAllDoctorsInHospital(long id);
    // Author
    @Query("select hds.hospital from HospitalDoctor hds where hds.doctorDetail.doctorId=:id")
    public List<Hospital> listAllHospitalOfDoctor(long id);


}
