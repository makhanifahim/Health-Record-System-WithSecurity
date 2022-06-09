package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.DoctorDetail;
import com.hrs.hrsystem.model.FamilyDoctor;
import com.hrs.hrsystem.model.User;

import java.util.List;

public interface FamilyDoctorService {
    FamilyDoctor saveFamilyDoctor(FamilyDoctor familyDoctor);
    void removeFamilyDoctor(Long id);
    List<DoctorDetail> findFamilyDoctorByUserId(long id);
    List<User> findFamilyClientsByDoctorId(long id);
}
