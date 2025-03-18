package com.documentmanagement.controller.mappers;

import com.documentmanagement.controller.dto.CreateMarkupRequestDTO;
import com.documentmanagement.controller.dto.MarkupApi;
import com.documentmanagement.domain.entity.Markup;

public class MarkupMapper implements DocumentAppMapper<MarkupApi, CreateMarkupRequestDTO, Markup> {

    @Override
    public MarkupApi toAPI(Markup entity) {
        return MarkupApi.builder()
                .position(entity.getPosition())
                .text(entity.getText())
                .type(entity.getType())
                .build();
    }

    @Override
    public Markup toEntity(CreateMarkupRequestDTO apiRequest) {
        return Markup.builder()
                .position(apiRequest.getPosition())
                .text(apiRequest.getText())
                .type(apiRequest.getType())
                .build();
    }
}
