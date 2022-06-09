package com.hrs.hrsystem.service;



import com.hrs.hrsystem.model.Documents;
import com.hrs.hrsystem.model.User;

import java.util.List;

public interface DocumentsService {
    Documents saveDocuments(Documents documents);
    Documents updateDocuments(Documents documents,Long id);
    void deleteDocument(Long id);
    List<Documents> findDocumentsByUserId(long id);
    User findUserByDocument(String docNo, String docType);

    Long findUserIdByDocument(String docNo, String docType);
}
