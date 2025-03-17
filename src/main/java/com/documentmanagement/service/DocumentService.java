package com.documentmanagement.service;

import com.documentmanagement.model.entity.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {

    private final DocumentRepository documentRepository;

    public Document addDocument(Document document) {

        return documentRepository.save(document);
    }

    public void deleteDocument(Long documentId) {

        documentRepository.deleteById(documentId);
    }

    public List<Document> getDocuments(String authorPrefix) {

        return documentRepository.findByAuthorStartingWith(authorPrefix);
    }

}
