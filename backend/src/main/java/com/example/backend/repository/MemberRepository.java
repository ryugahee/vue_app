package com.example.backend.repository;

import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 중복 회원 검사를 위한 이메일 확인
    Member findByEmail(String email);


}
