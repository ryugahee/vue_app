package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {
    private Long id;

    private String itemName;

    private int price;

    private String itemDetail;

    // 시간
    // 품목명
    // 대분류
    // 무게




    private String sellStatCd;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
