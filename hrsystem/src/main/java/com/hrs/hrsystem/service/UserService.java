package com.hrs.hrsystem.service;


import com.hrs.hrsystem.model.User;

public interface UserService {
    //Starting --Fahim
    //Registration
    User saveUser(User user);
    User updateUser(User user,long id);
    User getUserById(long id);
    User userDetailByName(String uName);
    void getUser();
    //Ending
}
