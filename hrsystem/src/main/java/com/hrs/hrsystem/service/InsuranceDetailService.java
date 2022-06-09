package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.InsuranceDetail;

import java.util.List;

public interface InsuranceDetailService {
    InsuranceDetail saveInsuranceDetail(InsuranceDetail insuranceDetail);
    List<InsuranceDetail> findAllByUserId(long id);
}
