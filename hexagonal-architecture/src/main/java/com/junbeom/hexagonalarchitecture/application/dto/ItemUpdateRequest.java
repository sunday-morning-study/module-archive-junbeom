package com.junbeom.hexagonalarchitecture.application.dto;

public record ItemUpdateRequest(
        Long id,
        String name,
        int price,
        int stockQuantity,
        String author,
        String isbn
) {
}
