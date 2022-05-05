package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.InsuranceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InsuranceDetailRepo extends JpaRepository<InsuranceDetail,Long> {
    // Author --Fahim
    @Query("select ids from InsuranceDetail ids where ids.user.userId=:id")
    public List<InsuranceDetail> findInsuranceDetailByUser(long id);
}
