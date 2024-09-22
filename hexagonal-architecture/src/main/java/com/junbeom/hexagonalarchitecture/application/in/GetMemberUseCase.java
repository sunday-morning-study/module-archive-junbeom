package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.application.dto.MemberResponse;

public interface GetMemberUseCase {

    MemberResponse findMemberById(Long id);
}
