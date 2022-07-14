package com.hrs.service.impl;

import com.hrs.exception.ResourceNotFoundException;
import com.hrs.model.Hospital;
import com.hrs.repository.HospitalRepo;
import com.hrs.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepo hospitalRepo;

    @Override
    public Hospital saveHospitalService(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    @Override
    public Hospital hospitalByUserName(String uName) {
        return hospitalRepo.HospitalDetailByName(uName);
    }

    @Override
    public Hospital updateHospital(Hospital hospital, long id) {
        Hospital existinghospital= hospitalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hospital","id",id));
        existinghospital.setAddress(hospital.getAddress());
        existinghospital.setEmail(hospital.getEmail());
        existinghospital.setDescription(hospital.getDescription());
        existinghospital.setMobileNo(hospital.getMobileNo());
        existinghospital.setName(hospital.getName());
        existinghospital.setType(hospital.getType());
        hospitalRepo.save(existinghospital);
        return existinghospital;
    }

    @Override
    public void UpdateHospitalCredential(Hospital hospital, long id) {
        Hospital existingHospital = hospitalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hospital","id",id));
        existingHospital.setCredential(hospital.getCredential());
        hospitalRepo.save(existingHospital);
    }
}
