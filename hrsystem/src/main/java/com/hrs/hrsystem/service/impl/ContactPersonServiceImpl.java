package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.exception.ResourceNotFoundException;
import com.hrs.hrsystem.model.ContactPersonDetail;
import com.hrs.hrsystem.repository.ContactPersonRepo;
import com.hrs.hrsystem.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {
    @Autowired
    private ContactPersonRepo contactPersonRepo;

    @Override
    public ContactPersonDetail saveContactPersonDetail(ContactPersonDetail contactPersonDetail) {
        return contactPersonRepo.save(contactPersonDetail);
    }

    @Override
    public List<ContactPersonDetail> findAllContactByUserId(long id) {
        return contactPersonRepo.findContactDetailByUser(id);
    }

    @Override
    public ContactPersonDetail updateContact(ContactPersonDetail contactPersonDetail, long id) {
        ContactPersonDetail existingDetail = contactPersonRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact Person Detail","id",id));
        existingDetail.setPerson(contactPersonDetail.getPerson());
        existingDetail.setRelation(contactPersonDetail.getRelation());
        contactPersonRepo.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteContact(long id) {
        contactPersonRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("ContactPersonService","id",id));
        contactPersonRepo.deleteById(id);
    }
}
