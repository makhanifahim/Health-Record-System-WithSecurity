package com.example.healthrecordsystemhrs.service;


import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.Hospital;
import com.example.healthrecordsystemhrs.model.HospitalDoctor;

import java.util.List;

public interface HospitalDoctorService {
    HospitalDoctor saveHospitalDoctor(HospitalDoctor hospitalDoctor);
    List<DoctorDetail> listAllDoctorsInHospital(long id);
    List<Hospital> listAllHospitalOfDoctor(long id);

}
