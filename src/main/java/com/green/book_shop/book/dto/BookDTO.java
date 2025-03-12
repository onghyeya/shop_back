package com.green.book_shop.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BookDTO {
  //	BOOK_CODE INT PRIMARY KEY AUTO_INCREMENT 	# 도서 코드
  //	, BOOK_NAME VARCHAR(30) NOT NULL 			# 도서 이름
  //	, BOOK_PRICE INT NOT NULL						# 도서 가격
  //	, PUBLISHER VARCHAR(30) NOT NULL				# 출판사
  //	, BOOK_INFO VARCHAR(100)						# 도서 내용
  //	, REG_DATE DATETIME DEFAULT SYSDATE()		# 도서 등록일
  //	, BOOK_STOCK INT DEFAULT 10  					# 재고
  //	, CATE_CODE INT NOT NULL REFERENCES book_category (CATE_CODE)
  private int bookCode;
  private String bookName;
  private int bookPrice;
  private String publisher;
  private String bookInfo;
  private LocalDateTime regDate;
  private int bookStock;
  private int cateCode;
}
