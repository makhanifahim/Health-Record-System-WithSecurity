package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.model.DoctorDetail;
import com.hrs.hrsystem.model.Hospital;
import com.hrs.hrsystem.model.HospitalDoctor;
import com.hrs.hrsystem.repository.HospitalDoctorRepo;
import com.hrs.hrsystem.service.HospitalDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalDoctorServiceImpl implements HospitalDoctorService {
    @Autowired
    private HospitalDoctorRepo hospitalDoctorRepo;

    @Override
    public HospitalDoctor saveHospitalDoctor(HospitalDoctor hospitalDoctor) {
        return hospitalDoctorRepo.save(hospitalDoctor);
    }

    @Override
    public List<DoctorDetail> listAllDoctorsInHospital(long id) {
        return hospitalDoctorRepo.listAllDoctorsInHospital(id);
    }

    @Override
    public List<Hospital> listAllHospitalOfDoctor(long id) {
        return hospitalDoctorRepo.listAllHospitalOfDoctor(id);
    }
}
