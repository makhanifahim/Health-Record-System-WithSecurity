package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.Address;
import com.example.healthrecordsystemhrs.repo.AddressRepo;
import com.example.healthrecordsystemhrs.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

}
