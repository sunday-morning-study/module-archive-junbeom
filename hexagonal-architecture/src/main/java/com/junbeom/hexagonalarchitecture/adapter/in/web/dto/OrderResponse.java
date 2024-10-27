package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

import com.junbeom.hexagonalarchitecture.domain.*;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        List<OrderItemResponse> orderItems,
        LocalDateTime orderDate,
        OrderStatus orderStatus,
        Long deliveryId,
        DeliveryStatus deliveryStatus,
        String deliveryCity,
        String deliveryStreet,
        String deliveryZipcode
) {
    public OrderResponse(Order order, List<OrderItemResponse> orderItems, Delivery delivery, Address deliveryAddress) {
        this(order.getId(), orderItems, order.getOrderDate(), order.getStatus(),
                delivery.getId(), delivery.getStatus(), deliveryAddress.getCity(),
                deliveryAddress.getStreet(), deliveryAddress.getZipcode());
    }
}
