package com.example.healthrecordsystemhrs.service;


import com.example.healthrecordsystemhrs.model.DoctorDetail;

public interface DoctorDetailService {

    DoctorDetail saveDoctorDetail(DoctorDetail doctorDetail);
    DoctorDetail DoctorDetailByUserName(String uName);
    DoctorDetail updateDoctor(DoctorDetail doctorDetail,long id);
}
