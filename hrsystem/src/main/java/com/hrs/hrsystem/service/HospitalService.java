package com.hrs.hrsystem.service;


import com.hrs.hrsystem.model.Hospital;

public interface HospitalService {
    Hospital saveHospitalService(Hospital hospital);
    Hospital hospitalByUserName(String uName);
    Hospital updateHospital(Hospital hospital,long id);
    void UpdateHospitalCredential(Hospital hospital,long id);
}
