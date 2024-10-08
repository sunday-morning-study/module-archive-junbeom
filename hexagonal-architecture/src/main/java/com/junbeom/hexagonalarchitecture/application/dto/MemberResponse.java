package com.junbeom.hexagonalarchitecture.application.dto;

import com.junbeom.hexagonalarchitecture.domain.Member;

public record MemberResponse(
        Long id,
        String name,
        String city,
        String street,
        String zipcode
) {
    public MemberResponse(Member member) {
        this(member.getId(), member.getName(),
                member.getAddress().getCity(),
                member.getAddress().getStreet(),
                member.getAddress().getZipcode());
    }
}
