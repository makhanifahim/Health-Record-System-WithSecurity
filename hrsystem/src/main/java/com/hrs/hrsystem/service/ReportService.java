package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.Report;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReportService {
    Report saveReport(Report report, MultipartFile file) throws IOException;
    Report updateReport(Report report,long id);
    List<Report> listReportByUserid(long id);
}
