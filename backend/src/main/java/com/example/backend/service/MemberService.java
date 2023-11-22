package com.example.backend.service;

import com.example.backend.dto.MemberFormDto;
import com.example.backend.entity.Member;
import com.example.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional  // 에러 발생시 콜백시켜줌
@RequiredArgsConstructor  // 생성자 생성
public class MemberService {

    // 생성자가 1개이면 어노테이션 없어도 됨
    private final MemberRepository memberRepository;

    /*
     * 회원가입
     * */
    public Member saveMember(Member member) {
        // 중복 회원 검증
        validateDuplicateMember(member);

        Member saveMember = memberRepository.save(member);

        return saveMember;
    }

    // 중복 회원의 경우 예외 발생시킴
    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    /*
     * 회원정보 조회
     * */

    public Member selectMember(Long id) {
        Member selectMember = memberRepository.findById(id).get();

        return selectMember;
    }

    /*
     * 회원정보 수정
     * */

    @Transactional
    public Member updateMember(Long id, MemberFormDto memberFormDto) {

        // 회원 수정
        Member selectMember = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 회원이 없습니다. id="+id));

        selectMember.updateMember(memberFormDto);
        Member saveMember = memberRepository.save(selectMember);
        // 이미지 등록


        return saveMember;
    }


}
