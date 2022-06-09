package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.model.Person;
import com.hrs.hrsystem.repository.PersonRepo;
import com.hrs.hrsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }
}
