package com.example.backend.controller;

import com.example.backend.dto.MemberFormDto;
import com.example.backend.entity.Member;
import com.example.backend.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    /*
     * 회원가입
     * */

    @PostMapping("/api/new")
    public String newMember(@RequestBody @Valid MemberFormDto memberFormDto) {
        System.out.println("memberFormDto = " + memberFormDto);
        Member member = Member.createMember(memberFormDto);
        memberService.saveMember(member);

        return "redirect:/";
    }

    /*
     * 회원정보 조회
     * */

    @GetMapping("/api/member/update/{id}")
    public Member memberUpdateForm(@PathVariable Long id) {
        return memberService.selectMember(id);
    }

    /*
     * 회원정보 수정
     * */

    @PostMapping("/api/member/update/{id}")
    public Member memberUpdate(@PathVariable Long id, @RequestBody @Valid MemberFormDto memberFormDto) {
        System.out.println("멤버정보 " + memberFormDto);
        return memberService.updateMember(id, memberFormDto);
    }



}
