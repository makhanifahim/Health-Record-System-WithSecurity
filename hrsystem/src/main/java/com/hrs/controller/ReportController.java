package com.hrs.controller;

import com.hrs.model.Report;
import com.hrs.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping(path = "/",consumes = "multipart/form-data")
    public ResponseEntity<Report> saveReport(@ModelAttribute Report report, @RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<Report>(reportService.saveReport(report,file), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Report>> getUserById(@PathVariable long id){
        return new ResponseEntity<List<Report>>(reportService.listReportByUserid(id),HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Report>> getDoctorById(@PathVariable long id){
        return new ResponseEntity<List<Report>>(reportService.listReportByDoctor(id),HttpStatus.OK);
    }

    @GetMapping("/doctoruser/{did}/{id}")
    public ResponseEntity<List<Report>> getReportUserDoctorById(@PathVariable long did,@PathVariable long id){
        return new ResponseEntity<List<Report>>(reportService.def(did,id),HttpStatus.OK);
    }

    //Updating Old Document ById
    @PutMapping("{id}")
    public ResponseEntity<Report> updateReport(@RequestBody Report report, @PathVariable long id){
        return new ResponseEntity<Report> (reportService.updateReport(report,id),HttpStatus.OK);
    }
}
