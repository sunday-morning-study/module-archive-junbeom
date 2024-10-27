package com.junbeom.hexagonalarchitecture.adapter.in.web;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderCreateRequest;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderResponse;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderSearchRequest;
import com.junbeom.hexagonalarchitecture.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Long> order(OrderCreateRequest orderCreateRequest) {
        Long orderId = orderService.createOrder(orderCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> orderList(@RequestBody OrderSearchRequest orderSearchRequest) {
        List<OrderResponse> orders = orderService.findOrders(orderSearchRequest);

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/orders/{orderId}/cancel")
    public ResponseEntity<Long> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orderId);
    }
}
