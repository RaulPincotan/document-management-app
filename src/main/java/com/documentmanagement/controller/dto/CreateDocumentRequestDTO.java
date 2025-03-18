package com.documentmanagement.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDocumentRequestDTO {
    private String name;
    private String classification;
    private Integer totalPages;
    private String author;
}
