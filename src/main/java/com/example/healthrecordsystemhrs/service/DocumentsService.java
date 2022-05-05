package com.example.healthrecordsystemhrs.service;


import com.example.healthrecordsystemhrs.model.Documents;
import com.example.healthrecordsystemhrs.model.User;

import java.util.List;

public interface DocumentsService {
    Documents saveDocuments(Documents documents);
    Documents updateDocuments(Documents documents,Long id);
    void deleteDocument(Long id);
    List<Documents> findDocumentsByUserId(long id);
    User findUserByDocument(String docNo, String docType);

    Long findUserIdByDocument(String docNo, String docType);
}
