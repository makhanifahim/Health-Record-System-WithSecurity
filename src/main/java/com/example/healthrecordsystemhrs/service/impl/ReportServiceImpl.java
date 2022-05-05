package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.exception.ResourceNotFoundException;
import com.example.healthrecordsystemhrs.model.Report;
import com.example.healthrecordsystemhrs.repo.ReportRepo;
import com.example.healthrecordsystemhrs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// Author --Fahim
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepo reportRepo;

    @Override
    public Report saveReport(Report report) {
        return reportRepo.save(report);
    }

    @Override
    public Report updateReport(Report report, long id) {
        Report existingreport = reportRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Report","id",id));
        existingreport.setReportDescription(report.getReportDescription());
        existingreport.setReportDocument(report.getReportDocument());
        existingreport.setReportPriority(report.getReportPriority());
        existingreport.setReportSubject(report.getReportSubject());
        existingreport.setReportType(report.getReportType());
        reportRepo.save(existingreport);
        return existingreport;
    }

    @Override
    public List<Report> listReportByUserid(long id) {
        List<Report> re=reportRepo.listReportByUserid(id);
        return re;
    }
    /*
     public List<Report> listReportByUserid(long id) {
        List<Object[]> re=reportRepo.listReportByUserid(id);
        List<Report> repolist = new ArrayList<>();
        for (Object[] a : re) {
            Report r=new Report();
            r.setReportId((Long)a[0]);
            r.getUser().setUserId((Long)a[1]);
            r.getDoctor().setDoctorId((Long)a[2]);
            r.setReportPriority((Integer) a[3]);
            r.setReportSubject((String) a[4]);
            r.setReportType((String) a[5]);
            r.setDateOfUpload((Date) a[6]);
            r.setReportDescription((String) a[7]);
            r.setReportDocument((String) a[8]);
            repolist.add(r);
        }
        return repolist;
    }
     */
}
