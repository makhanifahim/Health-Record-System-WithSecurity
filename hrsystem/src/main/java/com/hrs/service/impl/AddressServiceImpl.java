package com.hrs.service.impl;

import com.hrs.model.Address;
import com.hrs.repository.AddressRepo;
import com.hrs.service.AddressService;
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
