package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.service.impl.PersonServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Author --Fahim
@Data
@RestController
@NoArgsConstructor
@RequestMapping("/Person")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;


}
