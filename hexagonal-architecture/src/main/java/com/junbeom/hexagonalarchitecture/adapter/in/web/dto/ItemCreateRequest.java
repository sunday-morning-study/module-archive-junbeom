package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

public record ItemCreateRequest (
        Long id,
        String name,
        int price,
        int stockQuantity,
        String author,
        String isbn
) {
}