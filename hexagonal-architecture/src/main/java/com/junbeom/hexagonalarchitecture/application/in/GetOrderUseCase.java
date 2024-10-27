package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderResponse;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderSearchRequest;

import java.util.List;

public interface GetOrderUseCase {

    List<OrderResponse> findOrders(OrderSearchRequest orderSearchRequest);
}
