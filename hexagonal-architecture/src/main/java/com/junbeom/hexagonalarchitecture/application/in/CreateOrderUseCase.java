package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderCreateRequest;

public interface CreateOrderUseCase {

    Long createOrder(OrderCreateRequest orderCreateRequest);
}
