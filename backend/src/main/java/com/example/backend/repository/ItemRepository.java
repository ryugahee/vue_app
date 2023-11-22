package com.example.backend.repository;

import com.example.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository는 2개의 제네릭 타입 사용(엔티티 타입 클래스, 기본키 타입)
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>{
    /*
    * 쿼리 메소드
    * */
    List<Item> findByItemTitle(String itemTitle);  //find + By + 변수이름

    List<Item> findByItemTitleOrItemDetail(String itemTitle, String itemDetail);  //상품명, 상품 상세 설명 조회

    List<Item> findByMinPriceLessThan(Integer minPrice);  //파라미터로 넘어온 price 변수보다 값이 작은 상품 조회

    List<Item> findByMinPriceLessThanOrderByMinPriceDesc(Integer price);  //가격 내림차순으로 조회


}
