package com.hrs.controller;

import com.hrs.EmailSenderService;
import com.hrs.model.FeedBack;
import com.hrs.service.impl.FeedBackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackServiceImpl feedBackService;

    @Autowired
    private EmailSenderService service;

    @PostMapping
    public int saveFeedBack(@RequestBody FeedBack feedBack){
        System.out.println(feedBack);
        return feedBackService.saveFeedBackDetail(feedBack);
    }
}
