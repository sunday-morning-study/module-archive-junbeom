package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.MemberResponse;

public interface GetMemberUseCase {

    MemberResponse findMemberById(Long id);
}
