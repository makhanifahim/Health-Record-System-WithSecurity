package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.ContactPersonDetail;

import java.util.List;

public interface ContactPersonService {

    ContactPersonDetail saveContactPersonDetail(ContactPersonDetail contactPersonDetail);
    List<ContactPersonDetail> findAllContactByUserId(long id);
    ContactPersonDetail updateContact(ContactPersonDetail contactPersonDetail,long id);
    void deleteContact(long id);
}
