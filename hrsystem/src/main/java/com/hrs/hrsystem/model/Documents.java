package com.hrs.hrsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String documentType;
    private String documentNo;
    private String Document;
}
