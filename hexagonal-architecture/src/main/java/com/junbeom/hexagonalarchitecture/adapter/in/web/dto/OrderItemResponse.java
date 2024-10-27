package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

public record OrderItemResponse(
        Long itemId,
        int orderPrice,
        int count
) {}
