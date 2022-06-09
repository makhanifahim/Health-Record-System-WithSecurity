package com.hrs.hrsystem.controller;

import com.hrs.hrsystem.EmailSenderService;
import com.hrs.hrsystem.model.JwtRequest;
import com.hrs.hrsystem.model.JwtResponse;
import com.hrs.hrsystem.service.impl.ServiceJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private ServiceJwt serviceJwt;

    @Autowired
    private EmailSenderService service;


    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return serviceJwt.createJwtToken(jwtRequest);
    }

}
