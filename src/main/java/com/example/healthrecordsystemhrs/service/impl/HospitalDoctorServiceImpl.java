package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.Hospital;
import com.example.healthrecordsystemhrs.model.HospitalDoctor;
import com.example.healthrecordsystemhrs.repo.HospitalDoctorRepo;
import com.example.healthrecordsystemhrs.service.HospitalDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Author --Fahim
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
