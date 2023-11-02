package com.example.backend.controller;

import com.example.backend.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    /*
     * 상품 리스트
     * */
    //임시용. 나중에 아이템 리스트로 바꾸기
    @GetMapping(value="/")
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("상품1");
        items.add("상품2");
        items.add("상품3");
        items.add("상품4");
        items.add("상품5");
        items.add("상품6");

        return items;
    }
}
