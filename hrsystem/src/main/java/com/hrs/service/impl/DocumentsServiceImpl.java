package com.hrs.service.impl;


import com.hrs.exception.ResourceNotFoundException;
import com.hrs.model.Documents;
import com.hrs.model.User;
import com.hrs.repository.DocumentsRepo;
import com.hrs.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentsServiceImpl implements DocumentsService {
    @Autowired
    private DocumentsRepo documentsRepo;

    @Autowired
    private FileUploadService fileUploadService;

    @Override
    public Documents saveDocuments(Documents documents, MultipartFile file) throws IOException {
        String path=fileUploadService.uploadFile(file);
        documents.setDocument(path);
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
