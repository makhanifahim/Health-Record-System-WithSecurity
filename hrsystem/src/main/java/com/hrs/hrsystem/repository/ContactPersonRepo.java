package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.ContactPersonDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactPersonRepo extends JpaRepository<ContactPersonDetail,Long> {

    @Query("select cpd from ContactPersonDetail cpd where cpd.user.userId=:id")
    public List<ContactPersonDetail> findContactDetailByUser(long id);
}
