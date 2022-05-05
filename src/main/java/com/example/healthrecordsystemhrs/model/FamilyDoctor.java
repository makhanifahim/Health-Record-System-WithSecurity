package com.example.healthrecordsystemhrs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FamilyDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dfId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private DoctorDetail doctorDetail;
}
