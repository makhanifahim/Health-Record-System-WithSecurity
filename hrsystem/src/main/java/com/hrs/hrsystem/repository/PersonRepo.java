package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {
}
