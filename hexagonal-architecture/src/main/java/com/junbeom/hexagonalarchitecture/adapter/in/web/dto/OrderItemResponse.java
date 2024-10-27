package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

import com.junbeom.hexagonalarchitecture.domain.OrderItem;

public record OrderItemResponse(
        Long id,
        Long itemId,
        int orderPrice,
        int count
) {
    public OrderItemResponse(OrderItem orderItem) {
        this(orderItem.getId(), orderItem.getItem().getId(), orderItem.getOrderPrice(), orderItem.getCount());
    }
}
