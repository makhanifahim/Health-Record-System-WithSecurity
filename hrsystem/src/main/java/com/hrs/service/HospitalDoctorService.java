package com.hrs.service;

import com.hrs.model.DoctorDetail;
import com.hrs.model.Hospital;
import com.hrs.model.HospitalDoctor;

import java.util.List;

public interface HospitalDoctorService {
    HospitalDoctor saveHospitalDoctor(HospitalDoctor hospitalDoctor);
    List<DoctorDetail> listAllDoctorsInHospital(long id);
    List<Hospital> listAllHospitalOfDoctor(long id);
}
