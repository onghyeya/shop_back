package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  // 회원 조회 쿼리
  public UserDTO loginUser(UserDTO userDTO);

  // 회원 등록 쿼리
  public boolean joinUser(UserDTO userDTO);
  // id 중복 검사 쿼리
  public String usableUserId(String userId);
  // 전화 중복 검사 쿼리
  public String usableUserTel(String userTel);
}
