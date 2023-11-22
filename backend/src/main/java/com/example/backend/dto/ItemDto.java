package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {
    private Long id;

    private String itemTitle;

    private int minPrice;

    private String itemDetail;

    private int time;

    private String itemTag;

    private String itemType;

    private int weight;

    private boolean isSoldout;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
