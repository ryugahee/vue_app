package com.example.backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberFormDto {


    private String name;

    private String email;

    private String password;

    private String zipcode;  //우편 번호

    private String streetadr;  //지번 주소

    private String detailadr; //상세 주소

}
