package com.junbeom.hexagonalarchitecture.controller;

import com.junbeom.hexagonalarchitecture.application.OrderService;
import com.junbeom.hexagonalarchitecture.domain.Order;
import com.junbeom.hexagonalarchitecture.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Long> order(@RequestParam("memberId") Long memberId,
                                @RequestParam("itemId") Long itemId,
                                @RequestParam("count") int count) {

        orderService.order(memberId, itemId, count);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/orders/{orderId}/cancel")
    public ResponseEntity<Long> cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orderId);
    }
}
