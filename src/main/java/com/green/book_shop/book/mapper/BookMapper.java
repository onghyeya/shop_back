package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  // 도서 등록 쿼리 실행
  public void insertBook(BookDTO bookDTO);


  // 카테고리 목록 조회 쿼리 실행
  public List<BookCategoryDTO> selectCategoryList();
  // 카테고리 명 중복 확인 쿼리 실행
  public String UsableCateName(String cateName);
  // 카테고리 등록 쿼리 실행
  public int insertCate(String cateName);
  // 카테고리 수정 쿼리 실행
  public void updateCate(BookCategoryDTO bookCategoryDTO);
  // 카테고리 삭제 쿼리 실행
  public void delCate(int cateCode);
}
