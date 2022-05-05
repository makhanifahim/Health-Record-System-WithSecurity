package com.example.healthrecordsystemhrs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class InsuranceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long insuranceId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String insuranceName;
    private String insuranceNo;
    private String coverage;
    private String insuranceType;
    private Date insuranceExp;

}
