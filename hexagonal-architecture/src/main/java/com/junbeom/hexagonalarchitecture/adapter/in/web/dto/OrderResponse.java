package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

import com.junbeom.hexagonalarchitecture.domain.DeliveryStatus;
import com.junbeom.hexagonalarchitecture.domain.OrderStatus;

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
) {}
