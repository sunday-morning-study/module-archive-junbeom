package com.junbeom.hexagonalarchitecture.application.port.in;

import com.junbeom.hexagonalarchitecture.application.port.in.dto.MemberResponse;

public interface GetMemberUseCase {

    MemberResponse findMemberById(Long id);
}
