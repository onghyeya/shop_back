package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
  private final BookMapper bookMapper;

  //도서 등록 기능

  @Override
  public void insertBook(BookDTO bookDTO) {
    bookMapper.insertBook(bookDTO);
  }
  //카테고리 목록 조회기능
  @Override
  public List<BookCategoryDTO> selectCategoryList() {
    return bookMapper.selectCategoryList();
  }

  @Override
  public int insertCate(String cateName) {
    int result = 0;
    // 카테고리명이 중복인지 확인
    // cateName 이 null 이면 사용가능/ null 아니면 사용불가능
     String selectedCateName = bookMapper.UsableCateName(cateName);
    // 중복이 아니면 카테고리를 등록
    if(selectedCateName == null){
      result = bookMapper.insertCate(cateName);
    }
    return result;
  }

  @Override
  public void updateCate(BookCategoryDTO bookCategoryDTO) {
    bookMapper.updateCate(bookCategoryDTO);
  }

  @Override
  public void delCate(int cateCode) {
    bookMapper.delCate(cateCode);
  }

  
}
