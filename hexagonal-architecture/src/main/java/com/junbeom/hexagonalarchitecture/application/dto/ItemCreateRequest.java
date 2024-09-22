package com.junbeom.hexagonalarchitecture.application.dto;

public record ItemCreateRequest (
        Long id,
        String name,
        int price,
        int stockQuantity,
        String author,
        String isbn
) {
}