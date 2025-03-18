package com.documentmanagement.controller.mappers;

import java.util.List;

public interface DocumentAppMapper<A, C, E> {
    A toAPI(E entity);

    E toEntity(C apiRequest);

    default List<A> toAPIs(List<E> entities) {
        return entities.stream()
                .map(this::toAPI)
                .toList();
    }
}
