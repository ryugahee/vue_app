package com.example.backend.entity;

import com.example.backend.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String nickName;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 50)
    private String phone;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String zipcode;  //우편 번호

    @Column(length = 100)
    private String streetadr;  //도로명 주소

    @Column(length = 100)
    private String detailadr;  //상세 주소


    //Member 엔티티 생성
    public static Member createMember(MemberFormDto memberFormDto) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setNickName(memberFormDto.getNickName());
        member.setEmail(memberFormDto.getEmail());
        member.setPhone(memberFormDto.getPhone());
        member.setPassword(memberFormDto.getPassword());
        member.setZipcode(memberFormDto.getZipcode());
        member.setStreetadr(memberFormDto.getStreetadr());
        member.setDetailadr(memberFormDto.getDetailadr());

        return member;
    }

}
