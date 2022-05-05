package com.example.healthrecordsystemhrs.repo;

import com.example.healthrecordsystemhrs.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {
}
