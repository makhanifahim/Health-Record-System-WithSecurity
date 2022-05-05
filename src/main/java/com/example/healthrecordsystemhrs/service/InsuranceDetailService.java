package com.example.healthrecordsystemhrs.service;



import com.example.healthrecordsystemhrs.model.InsuranceDetail;

import java.util.List;

public interface InsuranceDetailService {
    InsuranceDetail saveInsuranceDetail(InsuranceDetail insuranceDetail);
    List<InsuranceDetail> findAllByUserId(long id);
}
