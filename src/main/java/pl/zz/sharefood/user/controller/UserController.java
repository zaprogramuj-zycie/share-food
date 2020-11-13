package pl.zz.sharefood.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.service.UserCreateService;
import pl.zz.sharefood.user.service.impl.UserListServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserListServiceImpl userListServiceImpl;
  private final UserCreateService userCreateService;

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto) {
    return userCreateService.save(userDto);
  }

  @GetMapping
  public PagedResponseDto<?> listUser(@RequestParam ListPageRequest listPageRequest) {
    return userListServiceImpl.execute(listPageRequest);
  }
}
