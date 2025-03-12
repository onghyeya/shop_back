package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class BookCategoryController {
  private final BookService bookService;

  // 카테고리 목록 조회
  @GetMapping("")
  public List<BookCategoryDTO> getCateList(){
    return bookService.selectCategoryList();
  }

  // 카테고리 등록
  @PostMapping("")
  public int insertCategory(@RequestBody BookCategoryDTO bookCategoryDTO){
    // 등록 성공 1 / 등록 안함 0 리턴함
    return bookService.insertCate(bookCategoryDTO.getCateName());
  }
  // 카테고리 수정
  @PutMapping("/{cateCode}")
  public void updateCategory(@PathVariable("cateCode") int cateCode,@RequestBody BookCategoryDTO bookCategoryDTO){
    bookCategoryDTO.setCateCode(cateCode);
    bookService.updateCate(bookCategoryDTO);
  }
  // 카테고리 삭제
  @DeleteMapping("/{cateCode}")
  public void deleteCategory(@PathVariable("cateCode") int cateCode){
    bookService.delCate(cateCode);
  }
}
