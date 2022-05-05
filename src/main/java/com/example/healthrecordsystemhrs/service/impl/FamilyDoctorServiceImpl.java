package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.FamilyDoctor;
import com.example.healthrecordsystemhrs.model.User;
import com.example.healthrecordsystemhrs.repo.FamilyDoctorRepo;
import com.example.healthrecordsystemhrs.service.FamilyDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Author --Fahim
@Service
public class FamilyDoctorServiceImpl implements FamilyDoctorService {
    @Autowired
    private FamilyDoctorRepo familyDoctorRepo;

    @Override
    public FamilyDoctor saveFamilyDoctor(FamilyDoctor familyDoctor) {
        return familyDoctorRepo.save(familyDoctor);
    }

    @Override
    public void removeFamilyDoctor(Long id) {
        familyDoctorRepo.deleteById(id);
    }

    @Override
    public List<DoctorDetail> findFamilyDoctorByUserId(long id) {
        return familyDoctorRepo.findFamilyDoctorByUserId(id);
    }

    @Override
    public List<User> findFamilyClientsByDoctorId(long id) {
        return familyDoctorRepo.findFamilyClientsByDoctorId(id);
    }



}
