package com.hrs.service.impl;

import com.hrs.model.FeedBack;
import com.hrs.repository.FeedBackRepo;
import com.hrs.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackRepo feedBackRepo;

    @Override
    public FeedBack saveFeedBackDetail(FeedBack feedBack) {
        System.out.println(feedBack.getDescription());
        return feedBackRepo.save(feedBack);
    }
}
