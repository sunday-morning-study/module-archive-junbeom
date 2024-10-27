package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

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
