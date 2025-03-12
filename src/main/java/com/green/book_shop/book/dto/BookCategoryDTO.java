package com.green.book_shop.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookCategoryDTO {
  //CATE_CODE INT PRIMARY KEY AUTO_INCREMENT 	# 카테고리 코드
  //	, CATE_NAME VARCHAR(30) NOT NULL UNIQUE 	# 카테고리 이름

  private int cateCode;
  private String cateName;
}
