package com.hrs.service;

import com.hrs.model.DoctorDetail;
import com.hrs.model.FamilyDoctor;
import com.hrs.model.User;

import java.util.List;

public interface FamilyDoctorService {
    FamilyDoctor saveFamilyDoctor(FamilyDoctor familyDoctor);
    void removeFamilyDoctor(Long id);
    List<DoctorDetail> findFamilyDoctorByUserId(long id);
    List<User> findFamilyClientsByDoctorId(long id);
}
