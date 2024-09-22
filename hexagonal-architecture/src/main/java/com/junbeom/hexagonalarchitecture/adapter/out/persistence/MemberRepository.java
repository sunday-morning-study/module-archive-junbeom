package com.junbeom.hexagonalarchitecture.adapter.out.persistence;

import com.junbeom.hexagonalarchitecture.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByName(String name);
}
