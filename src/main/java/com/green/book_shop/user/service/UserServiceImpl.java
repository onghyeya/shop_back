package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  private final UserMapper userMapper;

  // 로그인

  @Override
  public UserDTO loginUser(UserDTO userDTO) {
    return userMapper.loginUser(userDTO);
  }
  // 회원 가입
  @Override
  public boolean joinUser(UserDTO userDTO) {
    boolean isJoin = false;
    // id 중복 확인
    String selectUserId = userMapper.usableUserId(userDTO.getUserId());
    // 전화번호 중복확인
    String selectUserTel = userMapper.usableUserTel(userDTO.getUserTel());
    // react에서 입력한 값을 조회했을 때 값이 없을 때
    if(selectUserId == null && selectUserTel == null){
      userMapper.joinUser(userDTO);
      isJoin = false;
    }
    return isJoin;
  }


}
