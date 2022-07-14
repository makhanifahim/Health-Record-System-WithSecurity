package com.hrs.service.impl;

import com.hrs.model.Roles;
import com.hrs.repository.UserTypeRepo;
import com.hrs.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private UserTypeRepo userTypeRepo;

    @Override
    public Roles saveUserType(Roles userType) {
        return userTypeRepo.save(userType);
    }
}
