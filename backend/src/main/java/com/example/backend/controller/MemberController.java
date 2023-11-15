package com.example.backend.controller;

import com.example.backend.dto.MemberFormDto;
import com.example.backend.entity.Member;
import com.example.backend.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.backend.entity.QMember.member;


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

    @GetMapping("/api/member/update")
    public String memberUpdate(@RequestBody MemberFormDto memberFormDto, Model model) {
        Member member = memberService.memberUpdate(memberFormDto);
        model.addAttribute("updateMember", member);

        return "update";
    }

}
