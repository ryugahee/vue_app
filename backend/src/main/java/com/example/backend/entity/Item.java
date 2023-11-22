package com.example.backend.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Table(name="item")
@Entity
public class Item {

    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemTitle;

    @Column(nullable = false)
    private int minPrice;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Column(nullable = false)
    private int time;

    @Column(nullable = false, length = 50)
    private String itemTag;

    @Column(nullable = false)
    private String itemType;

    @Column(nullable = false)
    private int weight;

    @Column
    private boolean isSoldout;

//    @Enumerated(EnumType.STRING)
//    private ItemSellStatus itemSellStatus;  //상품 판매 상태



}
