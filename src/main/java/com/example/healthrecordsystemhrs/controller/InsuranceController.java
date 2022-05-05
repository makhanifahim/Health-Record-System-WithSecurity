package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.InsuranceDetail;
import com.example.healthrecordsystemhrs.service.impl.InsuranceDetailServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Author --Fahim
@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceDetailServiceImpl insuranceDetailService;
    //Add Insurance
    //Error While inserting Date in Expiry
    @PostMapping
    public ResponseEntity<InsuranceDetail> saveInsuranceDetail(@RequestBody InsuranceDetail insuranceDetail){
        return new ResponseEntity<InsuranceDetail>(insuranceDetailService.saveInsuranceDetail(insuranceDetail), HttpStatus.CREATED);
    }

    //find by userid
    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<InsuranceDetail>> findInsuranceDetailByUser(@PathVariable long id){
        return new ResponseEntity<List<InsuranceDetail>>(insuranceDetailService.findAllByUserId(id),HttpStatus.OK);
    }

}
