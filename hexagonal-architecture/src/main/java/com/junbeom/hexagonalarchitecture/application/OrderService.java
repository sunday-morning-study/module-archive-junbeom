package com.junbeom.hexagonalarchitecture.application;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderCreateRequest;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderItemResponse;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderResponse;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.OrderSearchRequest;
import com.junbeom.hexagonalarchitecture.adapter.out.persistence.MemberRepository;
import com.junbeom.hexagonalarchitecture.application.in.CreateOrderUseCase;
import com.junbeom.hexagonalarchitecture.application.in.GetOrderUseCase;
import com.junbeom.hexagonalarchitecture.application.in.UpdateOrderUseCase;
import com.junbeom.hexagonalarchitecture.domain.*;
import com.junbeom.hexagonalarchitecture.domain.item.Item;
import com.junbeom.hexagonalarchitecture.repository.ItemRepository;
import com.junbeom.hexagonalarchitecture.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService implements CreateOrderUseCase, UpdateOrderUseCase, GetOrderUseCase {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public Long createOrder(OrderCreateRequest orderCreateRequest) {
        Long memberId = orderCreateRequest.memberId();
        Long itemId = orderCreateRequest.itemId();
        int count = orderCreateRequest.count();

        //엔티티 조회
        Member member = memberRepository.findById(memberId).orElseThrow(NoSuchElementException::new);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);

        return order.getId();
    }

    /**
     * 주문 취소
     */
    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소
        order.cancel();
    }

    //검색
    @Override
    @Transactional
    public List<OrderResponse> findOrders(OrderSearchRequest orderSearchRequest) {
        List<Order> orders = orderRepository.findAllByString(orderSearchRequest);
        return orders.stream().map(order -> {
            List<OrderItem> orderItems = order.getOrderItems();
            List<OrderItemResponse> orderItemResponses = orderItems.stream()
                    .map(OrderItemResponse::new).toList();
            Delivery delivery = order.getDelivery();
            Address deliveryAddress = delivery.getAddress();
            return new OrderResponse(order, orderItemResponses, delivery, deliveryAddress);
        }).toList();
    }
}
