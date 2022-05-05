package com.example.healthrecordsystemhrs.repo;

import com.example.healthrecordsystemhrs.model.DoctorDetail;
import com.example.healthrecordsystemhrs.model.FamilyDoctor;
import com.example.healthrecordsystemhrs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyDoctorRepo extends JpaRepository<FamilyDoctor,Long> {
    // Author --Fahim
    @Query("select fdr.doctorDetail from FamilyDoctor fdr where fdr.user.userId=:id")
    public List<DoctorDetail> findFamilyDoctorByUserId(long id);
    // Author --Fahim
    @Query("select fdr.user from FamilyDoctor fdr where fdr.doctorDetail.doctorId=:id")
    public List<User> findFamilyClientsByDoctorId(long id);

}
