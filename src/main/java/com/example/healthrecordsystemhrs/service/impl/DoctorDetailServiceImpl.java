package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.exception.ResourceNotFoundException;
import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.repo.DoctorDetailRepo;
import com.example.healthrecordsystemhrs.service.DoctorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
// Author --Fahim
@Service
public class DoctorDetailServiceImpl implements DoctorDetailService {
    @Autowired
    private DoctorDetailRepo doctorDetailRepo;

    @Override
    public DoctorDetail saveDoctorDetail(DoctorDetail doctorDetail) {
        return doctorDetailRepo.save(doctorDetail);
    }

    @Override
    public DoctorDetail DoctorDetailByUserName(String uName) {
        return doctorDetailRepo.userDetailByName(uName);
    }

    @Override
    public DoctorDetail updateDoctor(DoctorDetail doctorDetail, long id) {
            DoctorDetail existingUser = doctorDetailRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("DoctorDetail","id",id));
            existingUser.setCredential(doctorDetail.getCredential());
            existingUser.setPerson(doctorDetail.getPerson());
            existingUser.setQualification(doctorDetail.getQualification());
            existingUser.setExperience(doctorDetail.getExperience());
            doctorDetailRepo.save(existingUser);
            return existingUser;
    }


}
