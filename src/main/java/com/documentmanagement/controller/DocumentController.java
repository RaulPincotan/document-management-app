package com.documentmanagement.controller;

import com.documentmanagement.controller.mappers.DocumentApi;
import com.documentmanagement.controller.mappers.DocumentMapper;
import com.documentmanagement.controller.mappers.MarkupApi;
import com.documentmanagement.controller.mappers.MarkupMapper;
import com.documentmanagement.model.entity.Document;
import com.documentmanagement.service.DocumentService;
import com.documentmanagement.service.MarkupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<DocumentApi> getDocuments(@RequestParam String author) {
        log.info("Get documents by author starting with [{}] request called", author);

        return getDocumentMapper().toAPIs(documentService.getDocuments(author));
    }

    @PostMapping
    public DocumentApi addDocument(@RequestBody Document document) {
        log.info("Add document request called");

        return getDocumentMapper().toAPI(documentService.addDocument(document));
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

    private MarkupMapper getMarkupMapper() {
        return new MarkupMapper();
    }

    private DocumentMapper getDocumentMapper() {
        return new DocumentMapper();
    }
}
