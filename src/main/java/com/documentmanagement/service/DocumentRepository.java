package com.documentmanagement.service;

import com.documentmanagement.domain.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Long> {
    List<Document> findByAuthorStartingWith(String prefix);
}
