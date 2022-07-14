package com.hrs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reportId;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    @ManyToOne
    @JoinColumn(name = "doctorId")
    private DoctorDetail doctor;

    private int reportPriority;
    private String reportSubject;
    private String reportType;
    private Date dateOfUpload;
    private String reportDescription;
    private String reportDocument;
}
