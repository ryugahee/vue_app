package com.example.backend.controller;

import com.example.backend.dto.ItemFormDto;
import com.example.backend.repository.ItemRepository;
import com.example.backend.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;
    @Autowired
    private final ItemRepository itemRepository;

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

    /*
    * 상품 조회
    * */




    /*
     * 상품 등록
     * */

    @PostMapping("/api/item/new")
    public ResponseEntity<String> itemNew(@Valid ItemFormDto itemFormDto,
                          @RequestParam("files") List<MultipartFile> itemImgFileList) {

        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("첫번째 상품 이미지는 필수 입력 값입니다.");
        }
        try {
            itemService.saveItem(itemFormDto, itemImgFileList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("상품 등록 중 에러가 발생했습니다.");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
