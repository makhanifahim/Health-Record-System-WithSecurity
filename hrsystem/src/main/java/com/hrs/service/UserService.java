package com.hrs.service;

import com.hrs.model.DoctorDetail;
import com.hrs.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user, long id);
    User getUserById(long id);
    User userDetailByName(String uName);
    void getUser();
    List<User> getAllUser();
}
