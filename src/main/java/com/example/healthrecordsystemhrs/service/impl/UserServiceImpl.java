package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.exception.ResourceNotFoundException;
import com.example.healthrecordsystemhrs.model.Credential;
import com.example.healthrecordsystemhrs.repo.UserRepo;
import com.example.healthrecordsystemhrs.service.UserService;
import com.example.healthrecordsystemhrs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Author --Fahim
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //Starting --Fahim
    //Registration
    @Override
    public User saveUser(User user) {
        Credential credential=user.getCredential();
        credential.setPassWord(passwordEncoder.encode(credential.getPassWord()));
        user.setCredential(credential);
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
        existingUser.setCredential(user.getCredential());
        existingUser.setPerson(user.getPerson());
        existingUser.setDescription(user.getDescription());
        userRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
    }

    @Override
    public User userDetailByName(String uName) {
        return userRepo.userDetailByName(uName);
    }

//    public String getEncodedPassword(String password){
//        return passwordEncoder.encode(password);
//    }

    //Ending
}
