package com.hrs.hrsystem.controller;


import com.hrs.hrsystem.model.Report;
import com.hrs.hrsystem.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping
    public ResponseEntity<Report> saveReport(@RequestBody Report report){
        return new ResponseEntity<Report>(reportService.saveReport(report), HttpStatus.CREATED);
    }

    //Updating Old Document ById
    @PutMapping("{id}")
    public ResponseEntity<Report> updateReport(@RequestBody Report report, @PathVariable long id){
        return new ResponseEntity<Report> (reportService.updateReport(report,id),HttpStatus.OK);
    }
}
