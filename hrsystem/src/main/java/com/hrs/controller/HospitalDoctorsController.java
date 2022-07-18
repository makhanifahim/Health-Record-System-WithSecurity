package com.hrs.controller;

import com.hrs.model.DoctorDetail;
import com.hrs.model.Hospital;
import com.hrs.model.HospitalDoctor;
import com.hrs.service.impl.HospitalDoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitaldoctor")
public class HospitalDoctorsController {
    @Autowired
    private HospitalDoctorServiceImpl hospitalDoctorService;

    @PostMapping
    public ResponseEntity<HospitalDoctor> saveHospitalDoctor(@RequestBody HospitalDoctor hospitalDoctor){
        return new ResponseEntity<HospitalDoctor>(hospitalDoctorService.saveHospitalDoctor(hospitalDoctor), HttpStatus.CREATED);
    }

    @GetMapping("/byHospital/{id}")
    public ResponseEntity<List<DoctorDetail>> listAllDoctorsInHospital(@PathVariable long id){
        return new ResponseEntity<List<DoctorDetail>>(hospitalDoctorService.listAllDoctorsInHospital(id),HttpStatus.OK);
    }

    @GetMapping("/byDoctor/{id}")
    public ResponseEntity<List<Hospital>> listAllHospitalOfDoctor(@PathVariable long id){
        return new ResponseEntity<List<Hospital>>(hospitalDoctorService.listAllHospitalOfDoctor(id),HttpStatus.OK);
    }
}
