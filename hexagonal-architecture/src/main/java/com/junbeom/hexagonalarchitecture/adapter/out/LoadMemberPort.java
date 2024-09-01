package com.junbeom.hexagonalarchitecture.adapter.out;

import com.junbeom.hexagonalarchitecture.domain.Member;

public interface LoadMemberPort {
    Member loadMemberById(Long id);
}
