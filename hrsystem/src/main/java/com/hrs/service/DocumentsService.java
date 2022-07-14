package com.hrs.service;

import com.hrs.model.Documents;
import com.hrs.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentsService {
    Documents saveDocuments(Documents documents, MultipartFile file) throws IOException;
    Documents updateDocuments(Documents documents,Long id);
    void deleteDocument(Long id);
    List<Documents> findDocumentsByUserId(long id);
    User findUserByDocument(String docNo, String docType);

    Long findUserIdByDocument(String docNo, String docType);
}
