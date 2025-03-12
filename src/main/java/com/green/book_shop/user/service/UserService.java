package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;


public interface UserService {
  // 회원 조회 쿼리
  public UserDTO loginUser(UserDTO userDTO);
  // 회원 등록 쿼리
  public boolean joinUser(UserDTO userDTO);
}
