package com.hrs.repository;

import com.hrs.model.DoctorDetail;
import com.hrs.model.FamilyDoctor;
import com.hrs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyDoctorRepo extends JpaRepository<FamilyDoctor,Long> {
    // Author
    @Query("select fdr.doctorDetail from FamilyDoctor fdr where fdr.user.userId=:id")
    public List<DoctorDetail> findFamilyDoctorByUserId(long id);
    // Author
    @Query("select fdr.user from FamilyDoctor fdr where fdr.doctorDetail.doctorId=:id")
    public List<User> findFamilyClientsByDoctorId(long id);
}
