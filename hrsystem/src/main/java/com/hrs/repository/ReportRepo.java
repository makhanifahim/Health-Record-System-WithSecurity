package com.hrs.repository;

import com.hrs.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report,Long> {
    @Query("select reports from Report reports where reports.user.userId=:id ")
    public List<Report> listReportByUserid(long id);

    @Query("select reports from Report reports where reports.doctor.doctorId=:id ")
    public List<Report> listReportByDoctorid(long id);

    @Query("select reports from Report reports where reports.doctor.doctorId=:did and reports.user.userId=:uid")
    public List<Report> abc(long did,long uid);
}
