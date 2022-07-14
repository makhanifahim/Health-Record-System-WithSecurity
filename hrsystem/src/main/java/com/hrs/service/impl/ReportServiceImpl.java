package com.hrs.service.impl;

import com.hrs.exception.ResourceNotFoundException;
import com.hrs.model.Report;
import com.hrs.repository.ReportRepo;
import com.hrs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private FileUploadService fileUploadService;

    @Override
    public Report saveReport(Report report, MultipartFile file) throws IOException {
        String path=fileUploadService.uploadFile(file);
        report.setReportDocument("C:\\soft\\"+path);
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

    public List<Report> listReportByDoctor(long id) {
        List<Report> dre=reportRepo.listReportByDoctorid(id);
        return dre;
    }

    public List<Report> def(long did,long uid){
        List<Report> rudid=reportRepo.abc(did,uid);
        return rudid;
    }
}
