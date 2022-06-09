package com.hrs.hrsystem.service.impl;


import com.hrs.hrsystem.exception.ResourceNotFoundException;
import com.hrs.hrsystem.model.Documents;
import com.hrs.hrsystem.model.User;
import com.hrs.hrsystem.repository.DocumentsRepo;
import com.hrs.hrsystem.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsServiceImpl implements DocumentsService {
    @Autowired
    private DocumentsRepo documentsRepo;

    @Override
    public Documents saveDocuments(Documents documents) {
        return documentsRepo.save(documents);
    }

    @Override
    public Documents updateDocuments(Documents documents, Long id) {
        Documents existingDocument =documentsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Document","id",id));
        existingDocument.setDocument(documents.getDocument());
        existingDocument.setDocumentNo(documents.getDocumentNo());
        existingDocument.setDocumentType(documents.getDocumentType());
        documentsRepo.save(existingDocument);
        return existingDocument;
    }

    @Override
    public void deleteDocument(Long id) {
        documentsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Document","id",id));
        documentsRepo.deleteById(id);
    }

    @Override
    public List<Documents> findDocumentsByUserId(long id) {
        return documentsRepo.findDocumentsByUserId(id);
    }

    @Override
    public User findUserByDocument(String docNo, String docType) {
        return documentsRepo.findUserByDocument(docNo,docType);
    }

    @Override
    public Long findUserIdByDocument(String docNo, String docType) {
        return documentsRepo.findUserIdByDocument(docNo,docType);
    }

}
