package com.example.backend.controller;

import com.example.backend.dto.MemberFormDto;
import com.example.backend.entity.Member;
import com.example.backend.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.backend.entity.QMember.member;


@Controller
@RequiredArgsConstructor
@ResponseBody
public class MemberController {

    private final MemberService memberService;
    /*
     * 회원가입
     * */

    @PostMapping("/api/new")
    public String newMember(@Valid MemberFormDto memberFormDto) {
        Member member = Member.createMember(memberFormDto);
        memberService.saveMember(member);

        return "redirect:/";
    }

}
