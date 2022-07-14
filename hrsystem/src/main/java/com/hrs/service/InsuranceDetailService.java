package com.hrs.service;

import com.hrs.model.InsuranceDetail;

import java.util.List;

public interface InsuranceDetailService {
    InsuranceDetail saveInsuranceDetail(InsuranceDetail insuranceDetail);
    List<InsuranceDetail> findAllByUserId(long id);
}
