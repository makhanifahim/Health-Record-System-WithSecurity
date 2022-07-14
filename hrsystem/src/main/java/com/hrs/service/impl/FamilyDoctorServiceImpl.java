package com.hrs.service.impl;

import com.hrs.model.DoctorDetail;
import com.hrs.model.FamilyDoctor;
import com.hrs.model.User;
import com.hrs.repository.FamilyDoctorRepo;
import com.hrs.service.FamilyDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
