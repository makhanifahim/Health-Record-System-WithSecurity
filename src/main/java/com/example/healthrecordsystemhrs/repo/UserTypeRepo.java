package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepo extends JpaRepository<Roles,Long> {

}
