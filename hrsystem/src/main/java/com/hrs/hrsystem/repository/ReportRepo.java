package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report,Long> {

    @Query("select reports from Report reports where reports.user.userId=:id ")
    public List<Report> listReportByUserid(long id);
}
