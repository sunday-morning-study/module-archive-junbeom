package com.junbeom.hexagonalarchitecture.adapter.in.web.dto;

public record OrderCreateRequest(
        Long memberId,
        Long itemId,
        int count
) {
}
