package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select user from User user where user.credential.userName=:uName")
    public User userDetailByName(String uName);

}
