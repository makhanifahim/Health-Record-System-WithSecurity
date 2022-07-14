package com.hrs.repository;

import com.hrs.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepo extends JpaRepository<Roles,Long> {

}
