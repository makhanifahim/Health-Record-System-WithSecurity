package com.example.healthrecordsystemhrs.service;


import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.FamilyDoctor;
import com.example.healthrecordsystemhrs.model.User;

import java.util.List;

public interface FamilyDoctorService {
    FamilyDoctor saveFamilyDoctor(FamilyDoctor familyDoctor);
    void removeFamilyDoctor(Long id);
    List<DoctorDetail> findFamilyDoctorByUserId(long id);
    List<User> findFamilyClientsByDoctorId(long id);
}
