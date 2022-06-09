package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.DoctorDetail;
import com.hrs.hrsystem.model.Hospital;
import com.hrs.hrsystem.model.HospitalDoctor;

import java.util.List;

public interface HospitalDoctorService {
    HospitalDoctor saveHospitalDoctor(HospitalDoctor hospitalDoctor);
    List<DoctorDetail> listAllDoctorsInHospital(long id);
    List<Hospital> listAllHospitalOfDoctor(long id);

}
