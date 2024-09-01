package com.junbeom.hexagonalarchitecture.adapter.in.web;

import com.junbeom.hexagonalarchitecture.controller.dto.MemberRequest;
import com.junbeom.hexagonalarchitecture.domain.Address;
import com.junbeom.hexagonalarchitecture.domain.Member;
import com.junbeom.hexagonalarchitecture.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/new")
    public ResponseEntity<Long> create(@RequestBody MemberRequest memberDto) {

        Address address = new Address(memberDto.city(), memberDto.street(), memberDto.zipcode());

        Member member = new Member();
        member.setName(memberDto.name());
        member.setAddress(address);

        Long memberId = memberService.join(member);
        return new ResponseEntity<>(memberId, HttpStatus.CREATED);
    }

//    @GetMapping("/members")
//    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }

}
