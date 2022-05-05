package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report,Long> {
    /*
    @Query("select reports.reportId,reports.user,reports.doctor,reports.reportPriority,reports.reportSubject,reports.reportType,reports.dateOfUpload,reports.reportDescription,reports.reportDocument from Report reports where reports.user.userId=:id ")
    public List<Object[]> listReportByUserid(long id);
     */
    @Query("select reports from Report reports where reports.user.userId=:id ")
    public List<Report> listReportByUserid(long id);
}
