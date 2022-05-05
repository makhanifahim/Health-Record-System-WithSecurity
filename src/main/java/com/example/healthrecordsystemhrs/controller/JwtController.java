package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.JwtRequest;
import com.example.healthrecordsystemhrs.model.JwtResponse;
import com.example.healthrecordsystemhrs.service.impl.ServiceJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private ServiceJwt serviceJwt;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return serviceJwt.createJwtToken(jwtRequest);
    }
}
