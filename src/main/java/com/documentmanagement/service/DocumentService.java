package com.documentmanagement.service;

import com.documentmanagement.controller.dto.UpdateDocumentRequestDTO;
import com.documentmanagement.exceptions.ResourceNotFoundException;
import com.documentmanagement.domain.entity.Document;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public List<Document> getDocuments(String authorPrefix) {
        if (Objects.isNull(authorPrefix)) {
            return documentRepository.findAll();
        }

        return documentRepository.findByAuthorStartingWith(authorPrefix);
    }

    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    @Transactional
    public Document updateDocument(Long documentId, UpdateDocumentRequestDTO updateRequest) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find document with id " + documentId));

        updateDocument(updateRequest, document);

        return documentRepository.save(document);
    }

    @Transactional
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    public Optional<Document> getDocument(Long documentId) {
        return documentRepository.findById(documentId);
    }

    public void updateDocument(UpdateDocumentRequestDTO updateRequest, Document document) {
        document.setName(updateRequest.getName());
        document.setAuthor(updateRequest.getAuthor());
        document.setClassification(updateRequest.getClassification());
    }
}
