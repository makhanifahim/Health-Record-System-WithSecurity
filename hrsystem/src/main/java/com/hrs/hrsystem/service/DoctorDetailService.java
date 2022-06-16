package com.hrs.hrsystem.service;


import com.hrs.hrsystem.model.DoctorDetail;

import java.util.List;

public interface DoctorDetailService {

    DoctorDetail saveDoctorDetail(DoctorDetail doctorDetail);
    DoctorDetail DoctorDetailByUserName(String uName);
    DoctorDetail updateDoctor(DoctorDetail doctorDetail,long id);
    List<DoctorDetail> getAlldoctors();
}
