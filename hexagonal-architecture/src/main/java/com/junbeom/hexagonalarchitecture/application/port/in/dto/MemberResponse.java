package com.junbeom.hexagonalarchitecture.application.port.in.dto;

public record MemberResponse(
        Long id,
        String name,
        String city,
        String street,
        String zipcode
) {
}
