package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.utill.UploadUtill;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtill uploadUtill;

  @PostMapping("")
  public void regBook(BookDTO bookDTO
                      ,@RequestParam(name = "mainImgFile") MultipartFile mainImg
                      ,@RequestParam(name = "detailImgFile") MultipartFile detailImg){
    //파일 첨부 기능
    String mainAttachedFileName = uploadUtill.fileUpload(mainImg); // 첨부된 파일명은 fileUpload() 메서드에서 만들어짐
    String detailAttachedFileName = uploadUtill.fileUpload(detailImg);

    // 다음에 들어 갈 BOOK_CODE 조회
    int nextBookCode = bookService.getNextBookCode();

    // Book 테이블에 도서 insert 기능
    bookDTO.setBookCode(nextBookCode); // bookCode를 조회된 수로 지정
    bookService.insertBook(bookDTO);

    // BookDTO 에 이미지 데이터 저장
    // 실제 데이터가 들어갈 통
    List<ImgDTO> imgList = new ArrayList<>();

    ImgDTO mainImgDTO = new ImgDTO();
    mainImgDTO.setOriginFileName(mainImg.getOriginalFilename());
    mainImgDTO.setAttachedFileName(mainAttachedFileName);
    mainImgDTO.setIsMain("Y");
    mainImgDTO.setBookCode(nextBookCode);

    ImgDTO detailImgDTO = new ImgDTO();
    detailImgDTO.setOriginFileName(detailImg.getOriginalFilename());
    detailImgDTO.setAttachedFileName(detailAttachedFileName);
    detailImgDTO.setIsMain("N");
    detailImgDTO.setBookCode(nextBookCode);

    imgList.add(mainImgDTO);
    imgList.add(detailImgDTO);
    bookDTO.setImgList(imgList);

    // BOOK_IMG 테이블에 도서 이미지 정보 insert
    bookService.insertImgs(bookDTO); // bookDTO

  }
}
