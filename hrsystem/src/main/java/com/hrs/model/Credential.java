package com.hrs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long credentialId;
    private String userName;

    @JsonBackReference
    private String passWord;
    ////    @ManyToOne
////    @JoinColumn(name = "userTypeId")
////    private UserType usertype;
//    @ElementCollection
//    List<String> UserType;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="USER_ROLE",joinColumns = {
            @JoinColumn(name="credentialId")
    },
            inverseJoinColumns = {
                    @JoinColumn(name="roleId")
            })
    private Set<Roles> role;
}
