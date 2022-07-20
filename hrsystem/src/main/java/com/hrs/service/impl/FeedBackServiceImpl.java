package com.hrs.service.impl;

import com.hrs.EmailSenderService;
import com.hrs.model.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl{

    @Autowired
    private EmailSenderService service;

    public int saveFeedBackDetail(FeedBack feedBack) {
        String message="\n"+"Feedback On : "+feedBack.getFeedbackOn().toString()+"\n"+"Subject : "+feedBack.getSubject()+"\n"+"Description : "+feedBack.getDescription();
        service.sendSimpleEmail("rishabhchindalia3333@gmail.com","By "+feedBack.getEmail()+message,"User Feedback");
        service.sendSimpleEmail(feedBack.getEmail(),message,"Your Feedback");
        return 1;
    }
}
