package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.exception.ResourceNotFoundException;
import com.hrs.hrsystem.model.Credential;
import com.hrs.hrsystem.model.User;
import com.hrs.hrsystem.repository.UserRepo;
import com.hrs.hrsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    String username=null;

    @Override
    public User saveUser(User user) {
        Credential credential=user.getCredential();
        credential.setPassWord(passwordEncoder.encode(credential.getPassWord()));
        user.setCredential(credential);
        username=user.getPerson().getEmail();
        return userRepo.save(user);
    }

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
        System.out.println(uuid);
        userRepo.updatestatus(uuid);
    }
}
