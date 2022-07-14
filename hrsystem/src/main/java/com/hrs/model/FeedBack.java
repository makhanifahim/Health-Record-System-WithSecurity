package com.hrs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Fd_Id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String Description;
    private String RelatedTo;
}
