package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

public record ItemUpdateRequest(
        Long id,
        String name,
        int price,
        int stockQuantity
) {
}
