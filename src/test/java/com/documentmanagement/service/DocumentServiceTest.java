package com.documentmanagement.service;

import com.documentmanagement.domain.entity.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DocumentServiceTest {

    @Mock
    private DocumentRepository documentRepositoryMock;

    @InjectMocks
    private DocumentService classUnderTest;


    @Test
    @DisplayName("""
            WHEN DocumentService.findByAuthorStartingWith is called
            THEN documents filtered by author should be returned
            """)
    void getDocumentsTest() {
        Document contract = getContractDocument();

        Document termsAndCons = Document.builder()
                .id(1L)
                .name("Terms and conditions")
                .classification("Informational")
                .totalPages(11)
                .author("Raplh")
                .build();

        List<Document> expectedDocuments = List.of(
                contract, termsAndCons
        );

        when(documentRepositoryMock.findByAuthorStartingWith("Ra"))
                .thenReturn(expectedDocuments);

        List<Document> actualDocumentsFound = classUnderTest.getDocuments("Ra");

        verify(documentRepositoryMock).findByAuthorStartingWith("Ra");
        assertEquals(expectedDocuments, actualDocumentsFound);
    }

    @Test
    @DisplayName("""
            WHEN DocumentService.addDocument is called
            THEN document should be saved
            """)
    public void addDocumentTest() {
        Document expectedSavedDocument = getContractDocument();
        when(documentRepositoryMock.save(expectedSavedDocument)).thenReturn(expectedSavedDocument);

        Document actualSavedDocument = classUnderTest.addDocument(expectedSavedDocument);

        verify(documentRepositoryMock).save(expectedSavedDocument);
        assertEquals(expectedSavedDocument, actualSavedDocument);
    }

    private Document getContractDocument() {
        return Document.builder()
                .id(1L)
                .name("electricity contract")
                .classification("Contract")
                .totalPages(11)
                .author("Raul")
                .build();
    }
}