package com.junbeom.hexagonalarchitecture.controller.dto;

public record MemberResponse(
        Long id,
        String name,
        String city,
        String street,
        String zipcode
) {
}
