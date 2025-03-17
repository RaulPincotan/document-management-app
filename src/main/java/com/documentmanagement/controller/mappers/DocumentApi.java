package com.documentmanagement.controller.mappers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentApi {

    private Long id;
    private String name;
    private String classification;
    private Integer totalPages;
    private String author;
}
