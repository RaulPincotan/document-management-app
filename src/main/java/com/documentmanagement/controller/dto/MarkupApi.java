package com.documentmanagement.controller.dto;

import com.documentmanagement.domain.enums.MarkupType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarkupApi {
    private String position;
    private String text;
    private MarkupType type;
}
