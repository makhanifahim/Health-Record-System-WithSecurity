package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.Report;

import java.util.List;

public interface ReportService {
    Report saveReport(Report report);
    Report updateReport(Report report,long id);
    List<Report> listReportByUserid(long id);
}
