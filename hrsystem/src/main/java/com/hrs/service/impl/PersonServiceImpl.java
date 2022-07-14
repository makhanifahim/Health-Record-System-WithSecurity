package com.hrs.service.impl;

import com.hrs.model.Person;
import com.hrs.repository.PersonRepo;
import com.hrs.service.PersonService;
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
