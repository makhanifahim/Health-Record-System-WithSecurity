package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.Roles;
import com.example.healthrecordsystemhrs.repo.UserTypeRepo;
import com.example.healthrecordsystemhrs.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Author --Fahim
@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private UserTypeRepo userTypeRepo;

    @Override
    public Roles saveUserType(Roles userType) {
        return userTypeRepo.save(userType);
    }
}
