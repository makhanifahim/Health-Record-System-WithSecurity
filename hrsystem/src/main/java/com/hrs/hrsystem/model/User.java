package com.hrs.hrsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credentialId")
    private Credential credential;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    private String description;
    private int status;
}
