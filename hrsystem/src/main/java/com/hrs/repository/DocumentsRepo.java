package com.hrs.repository;

import com.hrs.model.Documents;
import com.hrs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentsRepo extends JpaRepository<Documents,Long> {
    @Query("select doc from Documents doc where doc.user.userId=:id")
    public List<Documents> findDocumentsByUserId(long id);

    //Find User By Document No and Type
    @Query("select doc.user from Documents doc where doc.documentNo=:docNo and doc.documentType=:docType")
    public User findUserByDocument(String docNo, String docType);

    //Find UserId By Document No and Type
    @Query("select doc.user.userId from Documents doc where doc.documentNo=:docNo and doc.documentType=:docType")
    public Long findUserIdByDocument(String docNo, String docType);
}
