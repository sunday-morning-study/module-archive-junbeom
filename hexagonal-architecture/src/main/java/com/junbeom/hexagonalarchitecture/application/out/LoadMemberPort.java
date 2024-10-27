package com.junbeom.hexagonalarchitecture.application.out;

import com.junbeom.hexagonalarchitecture.domain.Member;

public interface LoadMemberPort {
    Member loadMemberById(Long id);
}
