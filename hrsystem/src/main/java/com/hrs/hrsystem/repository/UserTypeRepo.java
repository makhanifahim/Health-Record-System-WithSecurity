package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepo extends JpaRepository<Roles,Long> {

}
