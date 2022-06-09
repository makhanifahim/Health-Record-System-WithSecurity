package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.exception.ResourceNotFoundException;
import com.hrs.hrsystem.model.DoctorDetail;
import com.hrs.hrsystem.repository.DoctorDetailRepo;
import com.hrs.hrsystem.service.DoctorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
