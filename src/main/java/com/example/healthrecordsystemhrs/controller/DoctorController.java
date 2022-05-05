package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.repo.DoctorDetailRepo;
import com.example.healthrecordsystemhrs.response.Response;
import com.example.healthrecordsystemhrs.service.impl.DoctorDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Author --Fahim
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorDetailRepo doctorDetailRepo;
    @Autowired
    private DoctorDetailServiceImpl doctorDetailServiceImpl;

    //Registration of Doctor
    @PostMapping
    public ResponseEntity<Response> saveDoctorDetail(@RequestBody DoctorDetail doctorDetail){
        return new ResponseEntity<Response>(Response.send("Doctor Registered By id "+doctorDetailServiceImpl.saveDoctorDetail(doctorDetail).getDoctorId(),
                true),
                HttpStatus.CREATED);
        // return new ResponseEntity<DoctorDetail>(doctorDetailServiceImpl.saveDoctorDetail(doctorDetail),HttpStatus.CREATED);
    }

    //Doctor Detail by UserName
    @GetMapping("/byName/{uName}")
    public ResponseEntity<DoctorDetail> doctorDetailByName(@PathVariable String uName){
        return new ResponseEntity<DoctorDetail>(doctorDetailServiceImpl.DoctorDetailByUserName(uName),HttpStatus.OK);
    }

    //Update DoctorDetail
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDetail> updateDoctor(@RequestBody DoctorDetail doctorDetail,@PathVariable long id){
        return new ResponseEntity<DoctorDetail>(doctorDetailServiceImpl.updateDoctor(doctorDetail,id),HttpStatus.OK);
    }
}
