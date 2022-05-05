package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.FamilyDoctor;
import com.example.healthrecordsystemhrs.model.User;
import com.example.healthrecordsystemhrs.service.impl.FamilyDoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Author --Fahim
@RestController
@RequestMapping("/familyDoctor")
public class FamilyDoctorController {
    @Autowired
    private FamilyDoctorServiceImpl familyDoctorService;

    //Add as a family doctor as well as doctors client --Fahim
    @PostMapping
    public ResponseEntity<FamilyDoctor> saveFamilyDoctor(@RequestBody FamilyDoctor familyDoctor){
        return new ResponseEntity<FamilyDoctor>(familyDoctorService.saveFamilyDoctor(familyDoctor), HttpStatus.CREATED);
    }

    // Remove from relation --Fahim
    // Problem Not solved
   @DeleteMapping("{id}")
    public ResponseEntity<String> removeFamilyDoctor(@PathVariable long id){
        familyDoctorService.removeFamilyDoctor(id);
        return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<DoctorDetail>> findContactDetailByUser(@PathVariable long id){
        return new ResponseEntity<List<DoctorDetail>>(familyDoctorService.findFamilyDoctorByUserId(id),HttpStatus.OK);
    }

    @GetMapping("/byDoctor/{id}")
    public ResponseEntity<List<User>> findFamilyClientsByDoctorId(@PathVariable long id){
        return new ResponseEntity<List<User>>(familyDoctorService.findFamilyClientsByDoctorId(id),HttpStatus.OK);
    }
}
