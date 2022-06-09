package com.hrs.hrsystem.controller;


import com.hrs.hrsystem.service.impl.PersonServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@NoArgsConstructor
@RequestMapping("/Person")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;


}
