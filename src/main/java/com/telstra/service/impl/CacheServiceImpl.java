package com.telstra.service.impl;

import com.telstra.dao.IDocumentRepository;
import com.telstra.entity.DocumentsEntity;
import com.telstra.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CacheServiceImpl implements ICacheService {

    @Autowired
    private IDocumentRepository repository;

    @Override
    public void save(DocumentsEntity documentsEntity) {
        repository.save(documentsEntity);
    }

    @Override
    public Optional<DocumentsEntity> getDocumentById(int documentId) {
        return repository.getDocumentsEntityById(documentId);
    }

    @Override
    public void delete(DocumentsEntity documentsEntity) {
        repository.delete(documentsEntity);
    }
}
