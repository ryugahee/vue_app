package com.example.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {

    private String name;

    private String email;

    private String password;


    private String zipcode;  //우편 번호

    private String streetadr;  //지번 주소

    private String detailadr; //상세 주소
}
