package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.model.Roles;
import com.hrs.hrsystem.repository.UserTypeRepo;
import com.hrs.hrsystem.service.UserTypeService;
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
