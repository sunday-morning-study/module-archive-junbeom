package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

import com.junbeom.hexagonalarchitecture.domain.OrderStatus;

public record OrderSearchRequest(
        String memberName, // 회원 이름
        OrderStatus orderStatus // 주문 상태[ORDER, CANCEL]
) {}
