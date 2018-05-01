package com.telstra.service;

import com.telstra.entity.DocumentsEntity;

import java.util.Optional;


public interface ICacheService {

    void save(DocumentsEntity documentsEntity);
    Optional<DocumentsEntity> getDocumentById(int documentId);
    void delete(DocumentsEntity documentsEntity);
}
