package com.example.backend.controller;

import com.example.backend.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    /*
     * 상품 리스트
     * */
    //임시용. 나중에 아이템 리스트로 바꾸기
    @GetMapping("/api/items")
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("product1");
        items.add("product2");
        items.add("product3");
        items.add("product4");
        items.add("product5");
        items.add("product6");

        return items;
    }
}
