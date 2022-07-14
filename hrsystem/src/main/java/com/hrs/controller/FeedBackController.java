package com.hrs.controller;

import com.hrs.model.FeedBack;
import com.hrs.service.impl.FeedBackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackServiceImpl feedBackService;

    @PostMapping
    public ResponseEntity<FeedBack> saveFeedBack(@RequestBody FeedBack feedBack){
        System.out.println(feedBack);
        return new ResponseEntity<FeedBack>(feedBackService.saveFeedBackDetail(feedBack), HttpStatus.CREATED);
    }
}
