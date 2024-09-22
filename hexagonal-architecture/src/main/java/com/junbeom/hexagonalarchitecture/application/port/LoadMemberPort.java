package com.junbeom.hexagonalarchitecture.application.port;

import com.junbeom.hexagonalarchitecture.domain.Member;

public interface LoadMemberPort {
    Member loadMemberById(Long id);
}
