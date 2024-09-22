package com.junbeom.hexagonalarchitecture.adapter.out.persistence;

import com.junbeom.hexagonalarchitecture.application.port.LoadMemberPort;
import com.junbeom.hexagonalarchitecture.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberPersistenceAdapter implements LoadMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Member loadMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("id 해당하는 member가 없습니다"));
    }
}
