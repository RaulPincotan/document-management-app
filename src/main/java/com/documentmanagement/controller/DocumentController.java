package com.documentmanagement.controller;

import com.documentmanagement.controller.dto.CreateDocumentRequestDTO;
import com.documentmanagement.controller.dto.CreateMarkupRequestDTO;
import com.documentmanagement.controller.dto.DocumentApi;
import com.documentmanagement.controller.dto.MarkupApi;
import com.documentmanagement.controller.dto.UpdateDocumentRequestDTO;
import com.documentmanagement.controller.mappers.DocumentMapper;
import com.documentmanagement.controller.mappers.MarkupMapper;
import com.documentmanagement.domain.entity.Document;
import com.documentmanagement.service.DocumentService;
import com.documentmanagement.service.MarkupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("documents")
@RequiredArgsConstructor
@Slf4j
public class DocumentController {
    private final DocumentService documentService;
    private final MarkupService markupService;

    @GetMapping
    public List<DocumentApi> getDocuments(@RequestParam(required = false) String author) {
        log.info("Get documents by author starting with [{}] request called", author);

        return getDocumentMapper().toAPIs(documentService.getDocuments(author));
    }

    @PostMapping
    public DocumentApi addDocument(@RequestBody CreateDocumentRequestDTO documentRequest) {
        log.info("Add document request called");
        Document documentEntity = getDocumentMapper().toEntity(documentRequest);

        return getDocumentMapper().toAPI(documentService.addDocument(documentEntity));
    }

    @PutMapping("{documentId}")
    public DocumentApi updateDocument(@PathVariable Long documentId, @RequestBody UpdateDocumentRequestDTO updateRequest) {
        log.info("Update document with id [{}] request called", documentId);

        return getDocumentMapper().toAPI(documentService.updateDocument(documentId, updateRequest));
    }

    @DeleteMapping("{documentId}")
    public void deleteDocument(@PathVariable Long documentId) {
        log.info("Delete document with id [{}] request called", documentId);

        documentService.deleteDocument(documentId);
    }

    @GetMapping("{documentId}/markups")
    public List<MarkupApi> getMarkupsForDocument(@PathVariable Long documentId) {
        log.info("Get markups for document with id [{}] request called", documentId);

        return getMarkupMapper().toAPIs(markupService.getMarkupsForDocument(documentId));
    }

    @PostMapping("{documentId}/markups")
    public MarkupApi saveMarkup(@PathVariable Long documentId, @RequestBody CreateMarkupRequestDTO markupCreateRequest) {
        log.info("Add markup for document with id [{}] request called", documentId);

        return getMarkupMapper().toAPI(markupService.addMarkup(documentId, markupCreateRequest));
    }

    @DeleteMapping("{documentId}/markups")
    public void deleteMarkup(@PathVariable Long documentId) {
        log.info("Delete markup for document with id [{}] request called", documentId);

        markupService.deleteMarkupForDocument(documentId);
    }

    private MarkupMapper getMarkupMapper() {
        return new MarkupMapper();
    }

    private DocumentMapper getDocumentMapper() {
        return new DocumentMapper();
    }
}
