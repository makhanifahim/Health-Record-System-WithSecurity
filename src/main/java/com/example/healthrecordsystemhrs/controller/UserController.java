package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.EmergencyDetails;
import com.example.healthrecordsystemhrs.model.User;
import com.example.healthrecordsystemhrs.repo.UserRepo;
import com.example.healthrecordsystemhrs.response.Response;
import com.example.healthrecordsystemhrs.service.*;
import com.example.healthrecordsystemhrs.service.impl.ServiceJwt;
import com.example.healthrecordsystemhrs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Author --Fahim
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserService userService;
    @Autowired
    private FamilyDoctorService familyDoctorService;
    @Autowired
    private DocumentsService documentsService;
    @Autowired
    private InsuranceDetailService insuranceDetailService;
    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private ServiceJwt serviceJwt;

    //Registration Of User
    // starting --Fahim
    @PostMapping
    public ResponseEntity<Response> saveUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<Response>
                (Response.send("User Registered with id "+userServiceImpl.saveUser(user).getUserId(),true),
                        HttpStatus.CREATED);
       // return serviceJwt.createJwtToken(user);
        //return new ResponseEntity<User>(userServiceImpl.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return new ResponseEntity<User>(userServiceImpl.getUserById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> updateUser(@RequestBody User user,@PathVariable long id){
        return new ResponseEntity<Response>
                (Response.send("User Registered with id "+userServiceImpl.updateUser(user,id).getUserId(),true),
                        HttpStatus.OK);
    }

    @GetMapping("/byName/{uName}")
    public ResponseEntity<User> userDetailByName(@PathVariable String uName){
        return new ResponseEntity<User>(userServiceImpl.userDetailByName(uName),HttpStatus.OK);
    }

    @Autowired
    private EmergencyDetails emergencyDetails;
    @PutMapping("/Emergency/{id}")
    public ResponseEntity<EmergencyDetails> emergencyDetail(@PathVariable long id){
        emergencyDetails.setUser(userService.getUserById(id));
        emergencyDetails.setFamilyDoctors(familyDoctorService.findFamilyDoctorByUserId(id));
        emergencyDetails.setDocuments(documentsService.findDocumentsByUserId(id));
        emergencyDetails.setInsuranceDetails(insuranceDetailService.findAllByUserId(id));
        emergencyDetails.setContactPersonDetails(contactPersonService.findAllContactByUserId(id));
        emergencyDetails.setReports(reportService.listReportByUserid(id));
        return ResponseEntity.ok(emergencyDetails);
    }
}
