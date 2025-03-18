package com.documentmanagement.controller.mappers;

import com.documentmanagement.controller.dto.CreateDocumentRequestDTO;
import com.documentmanagement.controller.dto.DocumentApi;
import com.documentmanagement.domain.entity.Document;

public class DocumentMapper implements DocumentAppMapper<DocumentApi, CreateDocumentRequestDTO, Document> {

    @Override
    public DocumentApi toAPI(Document entity) {
        if (entity == null) {
            return null;
        }

        return DocumentApi.builder()
                .id(entity.getId())
                .name(entity.getName())
                .classification(entity.getClassification())
                .totalPages(entity.getTotalPages())
                .author(entity.getAuthor())
                .build();
    }

    @Override
    public Document toEntity(CreateDocumentRequestDTO documentApi) {
        return Document.builder()
                .name(documentApi.getName())
                .classification(documentApi.getClassification())
                .totalPages(documentApi.getTotalPages())
                .author(documentApi.getAuthor())
                .build();
    }
}
