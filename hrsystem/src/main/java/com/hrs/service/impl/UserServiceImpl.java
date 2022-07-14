package com.hrs.service.impl;

import com.hrs.EmailSenderService;
import com.hrs.exception.ResourceNotFoundException;
import com.hrs.model.Credential;
import com.hrs.model.DoctorDetail;
import com.hrs.model.User;
import com.hrs.repository.UserRepo;
import com.hrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailSenderService emailSenderService;

    String username=null;

    @Override
    public User saveUser(User user) {
        Credential credential=user.getCredential();
        credential.setPassWord(passwordEncoder.encode(credential.getPassWord()));
        user.setCredential(credential);
        username=user.getPerson().getEmail();
        return userRepo.save(user);
    }

//    @Override
//    public int OTPGenerate(){
//        int max=100000,min=555;
//        int x= (int) ((Math.random()*((max-min)+1))+min);
//        emailSenderService.sendSimpleEmail(username,String.valueOf(x),"OTP for health record system");
//        return x;
//    }

    @Override
    public User updateUser(User user,long id) {
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


    @Override
    public void getUser() {
        long uuid=userRepo.findId(username);
        userRepo.updatestatus(uuid);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        return userRepo.findAll();
    }

}
