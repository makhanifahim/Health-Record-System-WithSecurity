package com.example.healthrecordsystemhrs.repo;

import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.Hospital;
import com.example.healthrecordsystemhrs.model.HospitalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalDoctorRepo extends JpaRepository<HospitalDoctor,Long> {
    // Author --Fahim
    @Query("select hds.doctorDetail from HospitalDoctor hds where hds.hospital.hospitalId=:id")
    public List<DoctorDetail> listAllDoctorsInHospital(long id);
    // Author --Fahim
    @Query("select hds.hospital from HospitalDoctor hds where hds.doctorDetail.doctorId=:id")
    public List<Hospital> listAllHospitalOfDoctor(long id);


}
