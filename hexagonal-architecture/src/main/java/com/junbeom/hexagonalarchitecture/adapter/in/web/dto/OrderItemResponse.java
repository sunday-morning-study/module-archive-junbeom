package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

public record OrderItemResponse(
        Long id,
        Long itemId,
        int orderPrice,
        int count
) {}
