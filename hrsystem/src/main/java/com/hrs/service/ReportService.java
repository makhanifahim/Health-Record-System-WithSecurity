package com.hrs.service;

import com.hrs.model.Report;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReportService {
    Report saveReport(Report report, MultipartFile file) throws IOException;
    Report updateReport(Report report,long id);
    List<Report> listReportByUserid(long id);
    List<Report> listReportByDoctor(long id);
//    List<Report> listReportByUserDoctorId(long did,long uid);
}
