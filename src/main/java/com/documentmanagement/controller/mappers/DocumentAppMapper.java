package com.documentmanagement.controller.mappers;

import java.util.List;

public interface DocumentAppMapper<A, E> {

    A toAPI(E entity);

    E toEntity(A apiRequest);

    default List<A> toAPIs(List<E> entities) {
        return entities.stream()
                .map(this::toAPI)
                .toList();
    }

    default List<E> toEntities(List<A> apisRequest) {
        return apisRequest.stream()
                .map(this::toEntity)
                .toList();
    }

}
