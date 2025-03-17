package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  @PostMapping("")
  public void regBook(@RequestBody BookDTO bookDTO){
    //파일 첨부 기능

    // Book 테이블에 도서 insert 기능
    bookService.insertBook(bookDTO);
  }
}
