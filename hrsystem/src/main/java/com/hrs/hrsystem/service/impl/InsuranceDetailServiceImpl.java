package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.model.InsuranceDetail;
import com.hrs.hrsystem.repository.InsuranceDetailRepo;
import com.hrs.hrsystem.service.InsuranceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
