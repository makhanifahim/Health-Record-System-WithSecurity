package com.hrs.hrsystem.service;


import com.hrs.hrsystem.model.DoctorDetail;

public interface DoctorDetailService {

    DoctorDetail saveDoctorDetail(DoctorDetail doctorDetail);
    DoctorDetail DoctorDetailByUserName(String uName);
    DoctorDetail updateDoctor(DoctorDetail doctorDetail,long id);
}
