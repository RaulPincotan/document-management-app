package com.documentmanagement.controller.mappers;

import com.documentmanagement.model.entity.Document;

public class DocumentMapper implements DocumentAppMapper<DocumentApi, Document> {

    @Override
    public DocumentApi toAPI(Document entity) {
        if (entity == null) {
            return null;
        }

        return DocumentApi.builder()
                .name(entity.getName())
                .classification(entity.getClassification())
                .totalPages(entity.getTotalPages())
                .author(entity.getAuthor())
                .build();
    }

    @Override
    public Document toEntity(DocumentApi documentApi) {
        return Document.builder()
                .name(documentApi.getName())
                .classification(documentApi.getClassification())
                .totalPages(documentApi.getTotalPages())
                .author(documentApi.getAuthor())
                .build();
    }
}
