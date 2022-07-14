package com.hrs.service;

import com.hrs.model.Hospital;

public interface HospitalService {
    Hospital saveHospitalService(Hospital hospital);
    Hospital hospitalByUserName(String uName);
    Hospital updateHospital(Hospital hospital,long id);
    void UpdateHospitalCredential(Hospital hospital,long id);

}
