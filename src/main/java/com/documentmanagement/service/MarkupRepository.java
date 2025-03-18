package com.documentmanagement.service;

import com.documentmanagement.domain.entity.Markup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkupRepository extends JpaRepository<Markup, Long> {

    @Query("SELECT m FROM Markup m WHERE m.document.id = :documentId")
    List<Markup> findMarkupsForDocument(@Param("documentId") Long documentId);

    @Modifying
    @Query("DELETE FROM Markup m WHERE m.document.id = :documentId")
    void deleteByDocumentId(@Param("documentId") Long documentId);
}
