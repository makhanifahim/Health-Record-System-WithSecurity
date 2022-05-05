package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.Person;
import com.example.healthrecordsystemhrs.repo.PersonRepo;
import com.example.healthrecordsystemhrs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Author --Fahim
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }
}
