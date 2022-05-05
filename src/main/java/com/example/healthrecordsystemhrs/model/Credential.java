package com.example.healthrecordsystemhrs.model;

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
    private String passWord;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE",joinColumns = {
            @JoinColumn(name="credentialId")
    },
            inverseJoinColumns = {
                    @JoinColumn(name="roleId")
            })
    private Set<Roles> role;


}
