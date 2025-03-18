package com.documentmanagement.service;

import com.documentmanagement.controller.dto.CreateMarkupRequestDTO;
import com.documentmanagement.controller.mappers.MarkupMapper;
import com.documentmanagement.domain.entity.Document;
import com.documentmanagement.domain.entity.Markup;
import com.documentmanagement.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkupService {
    private final MarkupRepository markupRepository;
    private final DocumentService documentService;

    public List<Markup> getMarkupsForDocument(Long documentId) {
        return markupRepository.findMarkupsForDocument(documentId);
    }

    public Markup addMarkup(Long documentId, CreateMarkupRequestDTO markupRequest) {
        Document document = documentService.getDocument(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not found document with id " + documentId));

        MarkupMapper markupMapper = new MarkupMapper();
        Markup markup = markupMapper.toEntity(markupRequest);
        markup.setDocument(document);

        return markupRepository.save(markup);
    }

    @Transactional
    public void deleteMarkupForDocument(Long documentId) {
        markupRepository.deleteByDocumentId(documentId);
    }
}
