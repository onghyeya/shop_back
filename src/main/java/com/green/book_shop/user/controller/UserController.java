package com.green.book_shop.user.controller;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  // 회원가입
  @PostMapping("")
  public boolean userJoin(@RequestBody UserDTO userDTO){
    return userService.joinUser(userDTO);
  }

  // 로그인
  // 조회이기 때문에 post 가 아닌 get 방식으로 진행하는게 맞음
  // get 방식으로 현재 사용하지 않는 이유
  // @PathVariable,@RequestParam 으로 전달되는 데이터는
  // url 에 노출 > 아이디 비번 유출 우려심함
  @GetMapping("/login")
  public UserDTO login(UserDTO userDTO){
    //조회된 데이터 o : 로그인 o/조회된 데이터 x : 로그인 x
    UserDTO loginUser =  userService.loginUser(userDTO);
    return loginUser;
  }



}
