package com.example.healthrecordsystemhrs.controller;

import com.example.healthrecordsystemhrs.model.Documents;

import com.example.healthrecordsystemhrs.model.User;
import com.example.healthrecordsystemhrs.service.impl.DocumentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

// Author --Fahim
@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentsServiceImpl documentsService;

    //Adding new Document
    @PostMapping
    public ResponseEntity<Documents> saveDocuments(@RequestBody Documents documents){
        return new ResponseEntity<Documents> (documentsService.saveDocuments(documents), HttpStatus.CREATED);
    }

    //Updating Old Document ById
    @PutMapping("{id}")
    public ResponseEntity<Documents> updateDocuments(@RequestBody Documents documents,@PathVariable long id){
        return new ResponseEntity<Documents> (documentsService.updateDocuments(documents,id),HttpStatus.OK);
    }

    //Delete By Document Idq
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable long id){
        documentsService.deleteDocument(id);
        return new ResponseEntity<String>("Document Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<Documents>> findDocumentsByUserId(@PathVariable long id){
        return new ResponseEntity<List<Documents>>(documentsService.findDocumentsByUserId(id),HttpStatus.OK);
    }

    //Get User By Document Number and Type --Fahim
    @GetMapping("/find/{docType}/{docNo}")
    public ResponseEntity<User> findUserByDocument(@PathVariable String docNo, @PathVariable String docType){
        return new ResponseEntity<User>(documentsService.findUserByDocument(docNo,docType),HttpStatus.OK);
    }

}