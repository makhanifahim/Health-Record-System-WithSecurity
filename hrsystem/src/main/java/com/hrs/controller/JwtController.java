package com.hrs.controller;

import com.hrs.EmailSenderService;
import com.hrs.model.JwtRequest;
import com.hrs.model.JwtResponse;
import com.hrs.service.impl.ServiceJwt;
import com.hrs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private ServiceJwt serviceJwt;

    @Autowired
    private EmailSenderService service;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return serviceJwt.createJwtToken(jwtRequest);
    }

//    @PostMapping({"/OTPGenerate"})
//    public int OTP(){
//        return userService.OTPGenerate();
//    }
}
