package com.telstra.dao;

import com.telstra.entity.DocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IDocumentRepository extends JpaRepository<DocumentsEntity,Integer> {
    Optional<DocumentsEntity> getDocumentsEntityById(Integer id);
}
