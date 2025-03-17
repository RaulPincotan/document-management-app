package com.documentmanagement.controller.mappers;

import com.documentmanagement.model.entity.Markup;

public class MarkupMapper implements DocumentAppMapper<MarkupApi, Markup> {

    @Override
    public MarkupApi toAPI(Markup entity) {
        return MarkupApi.builder()
                .position(entity.getPosition())
                .text(entity.getText())
                .type(entity.getType())
                .build();
    }

    @Override
    public Markup toEntity(MarkupApi apiRequest) {
        return Markup.builder()
                .position(apiRequest.getPosition())
                .text(apiRequest.getText())
                .type(apiRequest.getType())
                .build();
    }
}
