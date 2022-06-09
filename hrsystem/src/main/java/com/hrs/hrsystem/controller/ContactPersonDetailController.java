package com.hrs.hrsystem.controller;


import com.hrs.hrsystem.model.ContactPersonDetail;
import com.hrs.hrsystem.service.impl.ContactPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactpersondetail")
public class ContactPersonDetailController {
    @Autowired
    private ContactPersonServiceImpl contactPersonService;

    @PostMapping
    public ResponseEntity<ContactPersonDetail> saveContactPersonDetail(@RequestBody ContactPersonDetail contactPersonDetail){
        return new ResponseEntity<ContactPersonDetail>(contactPersonService.saveContactPersonDetail(contactPersonDetail),HttpStatus.CREATED);
    }

    //Update by ContactId
    @PutMapping("/{id}")
    public ResponseEntity<ContactPersonDetail> updateContact(@RequestBody ContactPersonDetail contactPersonDetail,@PathVariable long id){
        return new ResponseEntity<ContactPersonDetail>(contactPersonService.updateContact(contactPersonDetail,id),HttpStatus.OK);
    }

    //find by user id
    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<ContactPersonDetail>> findAllContactByUserId(@PathVariable long id){
        return new ResponseEntity<List<ContactPersonDetail>>(contactPersonService.findAllContactByUserId(id),HttpStatus.OK);
    }

    //Delete Contact Person Detail
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        contactPersonService.deleteContact(id);
        return new ResponseEntity<String>("Contact Person Removed", HttpStatus.OK);
    }

}
