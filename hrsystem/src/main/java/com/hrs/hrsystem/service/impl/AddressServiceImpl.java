package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.model.Address;
import com.hrs.hrsystem.repository.AddressRepo;
import com.hrs.hrsystem.service.AddressService;
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
