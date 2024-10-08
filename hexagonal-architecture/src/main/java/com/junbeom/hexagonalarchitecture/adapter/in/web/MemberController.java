package com.junbeom.hexagonalarchitecture.adapter.in.web;

import com.junbeom.hexagonalarchitecture.application.in.GetMemberUseCase;
import com.junbeom.hexagonalarchitecture.application.dto.MemberResponse;
import com.junbeom.hexagonalarchitecture.application.dto.MemberRequest;
import com.junbeom.hexagonalarchitecture.domain.Address;
import com.junbeom.hexagonalarchitecture.domain.Member;
import com.junbeom.hexagonalarchitecture.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final GetMemberUseCase getMemberUseCase;

    @PostMapping("/new")
    public ResponseEntity<Long> create(@RequestBody MemberRequest memberDto) {

        Address address = new Address(memberDto.city(), memberDto.street(), memberDto.zipcode());

        Member member = new Member();
        member.setName(memberDto.name());
        member.setAddress(address);

        Long memberId = memberService.join(member);
        return new ResponseEntity<>(memberId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(getMemberUseCase.findMemberById(id));
    }

//    @GetMapping
//    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }

}
