package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.InsuranceDetail;
import com.example.healthrecordsystemhrs.repo.InsuranceDetailRepo;
import com.example.healthrecordsystemhrs.service.InsuranceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Author --Fahim
@Service
public class InsuranceDetailServiceImpl implements InsuranceDetailService {
    @Autowired
    private InsuranceDetailRepo insuranceDetailRepo;
    @Override
    public InsuranceDetail saveInsuranceDetail(InsuranceDetail insuranceDetail) {
        return insuranceDetailRepo.save(insuranceDetail);

    }

    @Override
    public List<InsuranceDetail> findAllByUserId(long id) {
        return insuranceDetailRepo.findInsuranceDetailByUser(id);

    }
}
