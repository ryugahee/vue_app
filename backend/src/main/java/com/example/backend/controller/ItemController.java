package com.example.backend.controller;

import com.example.backend.dto.ItemFormDto;
import com.example.backend.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

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

    @PostMapping("/api/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto,
                          Model model, @RequestParam("files") List<MultipartFile> itemImgFileList) {

        System.out.println("그림 확인: " + itemImgFileList);

        for (int i = 0; i < itemImgFileList.size(); i++) {
            System.out.println(itemImgFileList.get(i).getOriginalFilename());
        }

        // 상품 등록시 첫번째 이미지가 없다면 다시 상품 등록 페이지로 전환
        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값입니다.");
            return "";
        }

        // 상품 저장 로직 호출
        // 매개 변수로 상품 정보와 상품 이미지 정보를 담고 있는 itemImgFileList를 넘겨줌
        try {
            itemService.saveItem(itemFormDto, itemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생했습니다.");
            return "";
        }
        // 정상 등록시 메인 페이지로 이동
        return "";
    }
}
