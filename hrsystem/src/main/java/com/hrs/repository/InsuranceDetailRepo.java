package com.hrs.repository;

import com.hrs.model.InsuranceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InsuranceDetailRepo extends JpaRepository<InsuranceDetail,Long> {
    @Query("select ids from InsuranceDetail ids where ids.user.userId=:id")
    public List<InsuranceDetail> findInsuranceDetailByUser(long id);
}
