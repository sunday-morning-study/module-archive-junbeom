package com.junbeom.hexagonalarchitecture.service;

import com.junbeom.hexagonalarchitecture.application.port.LoadMemberPort;
import com.junbeom.hexagonalarchitecture.application.in.GetMemberUseCase;
import com.junbeom.hexagonalarchitecture.application.dto.MemberResponse;
import com.junbeom.hexagonalarchitecture.domain.Member;
import com.junbeom.hexagonalarchitecture.adapter.out.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements GetMemberUseCase {

    private final MemberRepository memberRepository;
    private final LoadMemberPort loadMemberPort;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public MemberResponse findMemberById(Long id) {
        Member member = loadMemberPort.loadMemberById(id);
        return new MemberResponse(member);
    }
}
