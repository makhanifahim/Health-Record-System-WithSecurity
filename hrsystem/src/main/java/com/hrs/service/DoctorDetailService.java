package com.hrs.service;

import com.hrs.model.DoctorDetail;

import java.util.List;

public interface DoctorDetailService {
    DoctorDetail saveDoctorDetail(DoctorDetail doctorDetail);
    DoctorDetail DoctorDetailByUserName(String uName);
    DoctorDetail updateDoctor(DoctorDetail doctorDetail,long id);
    List<DoctorDetail> getAlldoctors();
}
