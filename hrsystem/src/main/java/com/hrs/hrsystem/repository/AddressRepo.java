package com.hrs.hrsystem.repository;


import com.hrs.hrsystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
