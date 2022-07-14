package com.hrs.service.impl;

import com.hrs.exception.ResourceNotFoundException;
import com.hrs.model.Credential;
import com.hrs.model.DoctorDetail;
import com.hrs.repository.DoctorDetailRepo;
import com.hrs.service.DoctorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorDetailServiceImpl implements DoctorDetailService {
    @Autowired
    private DoctorDetailRepo doctorDetailRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public DoctorDetail saveDoctorDetail(DoctorDetail doctorDetail) {
        Credential credential=doctorDetail.getCredential();
        credential.setPassWord(passwordEncoder.encode(credential.getPassWord()));
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
    public List<DoctorDetail> getAlldoctors(){
        List<DoctorDetail> doctorDetail = new ArrayList<DoctorDetail>();
        return doctorDetailRepo.findAll();
    }
}
