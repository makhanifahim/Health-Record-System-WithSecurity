package com.example.healthrecordsystemhrs.controller;


import com.example.healthrecordsystemhrs.model.EmergencyDetails;
import com.example.healthrecordsystemhrs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Author --Fahim
@RestController
@RequestMapping("/EmergencyAccess")
public class EmergencyDetailController {
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
    private EmergencyDetails emergencyDetails;

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyDetails> emergencyDetail(@PathVariable long id){
        emergencyDetails.setUser(userService.getUserById(id));
        emergencyDetails.setFamilyDoctors(familyDoctorService.findFamilyDoctorByUserId(id));
        emergencyDetails.setDocuments(documentsService.findDocumentsByUserId(id));
        emergencyDetails.setInsuranceDetails(insuranceDetailService.findAllByUserId(id));
        emergencyDetails.setContactPersonDetails(contactPersonService.findAllContactByUserId(id));
        emergencyDetails.setReports(reportService.listReportByUserid(id));
        return ResponseEntity.ok(emergencyDetails);
    }

    //Get User By Document Number and Type --Fahim
    @GetMapping("/{docType}/{docNo}")
    public ResponseEntity<EmergencyDetails> findUserIdByDocument(@PathVariable String docNo,@PathVariable String docType){
        long id=documentsService.findUserIdByDocument(docNo,docType);
        emergencyDetails.setUser(userService.getUserById(id));
        emergencyDetails.setFamilyDoctors(familyDoctorService.findFamilyDoctorByUserId(id));
        emergencyDetails.setDocuments(documentsService.findDocumentsByUserId(id));
        emergencyDetails.setInsuranceDetails(insuranceDetailService.findAllByUserId(id));
        emergencyDetails.setContactPersonDetails(contactPersonService.findAllContactByUserId(id));
        emergencyDetails.setReports(reportService.listReportByUserid(id));
        return ResponseEntity.ok(emergencyDetails);
    }
}
