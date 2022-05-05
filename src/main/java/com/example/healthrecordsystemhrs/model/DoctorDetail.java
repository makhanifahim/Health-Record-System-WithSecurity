package com.example.healthrecordsystemhrs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@NoArgsConstructor
public class DoctorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long doctorId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credentialId")
    private Credential credential;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;
    private String qualification;
    private String experience;
    private int status;
}
