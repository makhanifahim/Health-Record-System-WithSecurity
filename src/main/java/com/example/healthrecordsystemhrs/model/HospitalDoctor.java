package com.example.healthrecordsystemhrs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class HospitalDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hdId;
    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "DoctorId")
    private DoctorDetail doctorDetail;
    private int status;
}
