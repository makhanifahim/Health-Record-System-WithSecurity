package com.hrs.controller;

import com.hrs.model.Hospital;
import com.hrs.response.Response;
import com.hrs.service.impl.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalServiceImpl hospitalService;

    @PostMapping
    public ResponseEntity<Response> saveHospital(@RequestBody Hospital hospital){
        return new ResponseEntity<Response>(Response.send("Hospital Registered with id "+hospitalService.saveHospitalService(hospital),true),HttpStatus.CREATED);
        //return new ResponseEntity<Hospital>(hospitalService.saveHospitalService(hospital), HttpStatus.CREATED);
    }

    @GetMapping("/byName/{uName}")
    public ResponseEntity<Hospital> HospitalByUserName(@PathVariable String uName){
        return new ResponseEntity<Hospital>(hospitalService.hospitalByUserName(uName), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@RequestBody Hospital hospital,@PathVariable long id){
        return new ResponseEntity<Hospital>(hospitalService.updateHospital(hospital,id),HttpStatus.OK);
    }
}
