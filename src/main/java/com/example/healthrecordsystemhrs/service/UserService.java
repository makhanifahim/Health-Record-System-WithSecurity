package com.example.healthrecordsystemhrs.service;


import com.example.healthrecordsystemhrs.model.User;

public interface UserService {
    //Starting --Fahim
    //Registration
    User saveUser(User user);
    User updateUser(User user,long id);

    //Starting --Fahim
    //Registration

    User getUserById(long id);
    User userDetailByName(String uName);
    //Ending
}
