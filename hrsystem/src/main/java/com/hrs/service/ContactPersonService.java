package com.hrs.service;

import com.hrs.model.ContactPersonDetail;

import java.util.List;

public interface ContactPersonService {
    ContactPersonDetail saveContactPersonDetail(ContactPersonDetail contactPersonDetail);
    List<ContactPersonDetail> findAllContactByUserId(long id);
    ContactPersonDetail updateContact(ContactPersonDetail contactPersonDetail,long id);
    void deleteContact(long id);
}
