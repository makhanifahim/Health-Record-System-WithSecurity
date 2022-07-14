package com.hrs.service.impl;

import com.hrs.model.DoctorDetail;
import com.hrs.model.Hospital;
import com.hrs.model.HospitalDoctor;
import com.hrs.repository.HospitalDoctorRepo;
import com.hrs.service.HospitalDoctorService;
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
