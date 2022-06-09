package com.hrs.hrsystem.controller;


import com.hrs.hrsystem.model.InsuranceDetail;
import com.hrs.hrsystem.service.impl.InsuranceDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceDetailServiceImpl insuranceDetailService;

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
