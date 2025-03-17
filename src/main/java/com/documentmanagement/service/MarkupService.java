package com.documentmanagement.service;

import com.documentmanagement.model.entity.Markup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarkupService {

    private final MarkupRepository markupRepository;

    public List<Markup> getMarkupsForDocument(Long documentId) {

        return markupRepository.findMarkupsByDocumentId(documentId);
    }
}
