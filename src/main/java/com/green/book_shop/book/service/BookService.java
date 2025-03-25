package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;

import java.util.List;

public interface BookService {
  // 도서 등록
  public void insertBook(BookDTO bookDTO);

  // 카테고리 목록 조회
  public List<BookCategoryDTO> selectCategoryList();
  // 카테고리 등록
  public int insertCate(String cateName);
  // 카테고리 수정
  public void updateCate(BookCategoryDTO bookCategoryDTO);
  // 카테고리 삭제
  public void delCate(int cateCode);
  // 도서 이미지 등록
  public void insertImgs(BookDTO bookDTO);
  // 다음에 들어 갈 BOOK_CODE 조회
  public int getNextBookCode();
}
