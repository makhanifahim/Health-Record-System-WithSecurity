package com.example.healthrecordsystemhrs.service;



import com.example.healthrecordsystemhrs.model.Report;

import java.util.List;

public interface ReportService {
    Report saveReport(Report report);
    Report updateReport(Report report,long id);
    List<Report> listReportByUserid(long id);
}
