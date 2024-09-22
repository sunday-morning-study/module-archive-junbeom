package com.junbeom.hexagonalarchitecture.application.dto;

import lombok.Builder;

@Builder
public record ItemResponse(
        Long id,
        String name,
        int price,
        int stockQuantity,
        String author,
        String isbn
) {
}
