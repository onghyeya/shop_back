package com.green.book_shop.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDTO {
//  CREATE TABLE SHOP_USER(
//	USER_ID VARCHAR(30) PRIMARY KEY
//	, USER_PW VARCHAR(30) NOT NULL
//	, USER_NAME VARCHAR(10) NOT NULL
//	, USER_EMAIL VARCHAR(30)
//	, USER_TEL VARCHAR(16) NOT NULL UNIQUE
//	, USER_ROLL VARCHAR(10) DEFAULT 'USER' # 권한 : USER-사용자, ADMIN-관리자
//	, IS_USING VARCHAR(10) DEFAULT 'Y' 		# 상태 : Y- 사용 중, N- 탈퇴
//	, JOIN_DATE DATETIME DEFAULT SYSDATE()
//)
  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
  private String userTel;
  private String userRoll;
  private String isUsing;
  private LocalDateTime joinDate;

}
