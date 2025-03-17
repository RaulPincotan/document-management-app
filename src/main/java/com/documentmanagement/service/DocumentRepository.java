package com.documentmanagement.service;

import com.documentmanagement.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Long> {

    List<Document> findByAuthorStartingWith(String prefix);
}
