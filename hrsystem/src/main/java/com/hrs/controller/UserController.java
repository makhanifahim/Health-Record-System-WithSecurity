package com.hrs.controller;

import com.hrs.EmailSenderService;
import com.hrs.model.DoctorDetail;
import com.hrs.model.EmergencyDetails;
import com.hrs.model.User;
import com.hrs.repository.UserRepo;
import com.hrs.response.Response;
import com.hrs.service.*;
import com.hrs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
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
    private EmailSenderService service;

    public UserController() {
    }

    //Registration Of User
    @PostMapping
    public ResponseEntity<Response> saveUser(@RequestBody User user, HttpServletRequest request){
        triggerMail(user.getPerson().getEmail(),applicationUrl(request)+"/user/verifyRegistration?link="+user.getCredential().getUserName());
        return new ResponseEntity<Response>
                (Response.send("User Registered with email "+userServiceImpl.saveUser(user).getPerson().getEmail(),true),
                        HttpStatus.CREATED);
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("link") String link) {
        userService.getUser();
        return "User Verified";
    }

    public void triggerMail(String email,String bodyEmail){
        service.sendSimpleEmail(email,bodyEmail,"Link to verify user for health record system");
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
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

    //list of users
    @GetMapping
    public ResponseEntity<List<User>> getallUsers(){
        return new ResponseEntity<List<User>>(userServiceImpl.getAllUser(),HttpStatus.OK);
    }
}
