package com.junbeom.hexagonalarchitecture.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public record MemberRequest (
        Long id,
        @NotEmpty(message = "회원 이름은 필수 입니다") String name,
        String city,
        String street,
        String zipcode
){
}
