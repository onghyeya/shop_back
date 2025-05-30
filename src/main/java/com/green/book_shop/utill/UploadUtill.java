package com.green.book_shop.utill;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component // 애매하면 component 를 많이 사용함.
// 첨부 파일 기능 모음 클래스
public class UploadUtill {
  // application.properties 파일에 정의한
  // file.upload.dir 값을 가져와서 uploadPath 에 저장
  @Value("${file.upload.dir}")
  private String uploadPath;

  // 단일 파일 업로드 기능
  public String fileUpload(MultipartFile file){

    // 파일을 첨부했을 때만
    if(file != null){

      // 화면에서 선택한 원본 파일명
      String originFileName = file.getOriginalFilename();

      // 첨부할 파일명
      String attachedFileName = getAttachedFileName(originFileName);

      // 업로드 경로 + 파일명 연결
      File f = new File( uploadPath + attachedFileName);

      // 예외 처리 try,catch,finally
      try {
        // 파일 첨부 실행코드
        // 첨부한 파일(file)을 실제 업로드 할 경로(f)로 옮긴다
        file.transferTo(f);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      return attachedFileName;
    }
    return null;

  }

  // 다중 파일 업로드 기능
  public void multiFileUpload(MultipartFile[] files){

    for(MultipartFile eachFile: files){
      fileUpload(eachFile);
    }
  }

  // 원본 파일명에서 첨부할 파일명을 생성하는 메서드
  public String getAttachedFileName(String originFileName){
    // 첨부할 파일 명( 랜덤한 문자열 생성 )
    // 예시 ) abc.jpg >> dfd-dssdfd-dfsdaf-dfdf(uuid).jpg(확장자)
    String uuid = UUID.randomUUID().toString();

    // 화면에서 선택한 파일의 확장자 추출
    String[] result = originFileName.split("\\.");
    String extension = result[result.length-1];

    // 완성 된 첨부 할 파일명
    String attachFileName = uuid + "." + extension;
    return attachFileName;
  }

}
