package com.example.backend.dto;

import com.example.backend.entity.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Data
public class MemberFormDto {

    private String name;

    private String nickName;

    private String email;

    private String phone;

    private String password;

    private String zipcode;  //우편 번호

    private String streetadr;  //지번 주소

    private String detailadr; //상세 주소

}
