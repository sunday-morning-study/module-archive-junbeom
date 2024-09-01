package com.junbeom.hexagonalarchitecture.repository;

import com.junbeom.hexagonalarchitecture.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByName(String name);
}
