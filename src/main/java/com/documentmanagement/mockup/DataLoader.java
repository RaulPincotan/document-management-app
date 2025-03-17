package com.documentmanagement.mockup;

import com.documentmanagement.model.entity.Document;
import com.documentmanagement.model.entity.Markup;
import com.documentmanagement.model.enums.MarkupType;
import com.documentmanagement.service.DocumentRepository;
import com.documentmanagement.service.MarkupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final MarkupRepository markupRepository;
    private final DocumentRepository documentRepository;

    @Override
    public void run(String... args) throws Exception {
        Document invoice = Document.builder()
                .name("Invoice")
                .classification("Confidential")
                .author("Raul")
                .totalPages(78)
                .build();
        Document payslip = Document.builder()
                .name("Payslip")
                .classification("Confidential")
                .author("Raul")
                .totalPages(78)
                .build();
        Document termsAndConditions = Document.builder()
                .name("Contract Terms and Conditions")
                .classification("Terms and Conditions")
                .author("Ralph")
                .totalPages(105)
                .build();
        documentRepository.saveAll(List.of(
                invoice,
                termsAndConditions,
                payslip
        ));

        markupRepository.saveAll(List.of(Markup.builder()
                        .type(MarkupType.PROCEDURAL)
                        .text("to inform")
                        .position("Row 35, column 15")
                        .document(invoice)
                        .build(),
                Markup.builder()
                        .type(MarkupType.PROCEDURAL)
                        .text("to do")
                        .position("Row 22, column 11")
                        .document(invoice)
                        .build(),
                Markup.builder()
                        .type(MarkupType.PRESENTATIONAL)
                        .text("terms")
                        .position("Row 7, column 17")
                        .document(termsAndConditions)
                        .build()
        ));
    }
}
