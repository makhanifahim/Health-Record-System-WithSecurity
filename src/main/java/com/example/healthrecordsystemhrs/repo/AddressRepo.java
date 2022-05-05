package com.example.healthrecordsystemhrs.repo;


import com.example.healthrecordsystemhrs.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
