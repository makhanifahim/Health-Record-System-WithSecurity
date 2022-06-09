package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select user from User user where user.credential.userName=:uName")
    public User userDetailByName(String uName);

    @Query("select user.person.personId from User user where user.person.firstName=:uName")
    public long findId(String uName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User user SET user.status=1 where user.person.personId=:id")
    public void updatestatus(long id);

}