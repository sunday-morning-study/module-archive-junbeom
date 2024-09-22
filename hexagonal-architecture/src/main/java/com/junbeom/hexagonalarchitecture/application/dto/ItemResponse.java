package com.junbeom.hexagonalarchitecture.application.dto;

public record ItemResponse(
        Long id,
        String name,
        int price,
        int stockQuantity,
        String author,
        String isbn
) {
}
