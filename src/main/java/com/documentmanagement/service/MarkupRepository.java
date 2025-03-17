package com.documentmanagement.service;

import com.documentmanagement.model.entity.Markup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkupRepository extends JpaRepository<Markup, Long> {

    @Query("SELECT m FROM Markup m WHERE m.document.id = :documentId")
    List<Markup> findMarkupsByDocumentId(@Param("documentId") Long documentId);
}
