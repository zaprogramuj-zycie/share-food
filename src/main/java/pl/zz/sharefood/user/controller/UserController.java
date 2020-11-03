package pl.zz.sharefood.user.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.repository.UserRepository;
import pl.zz.sharefood.user.service.UserCreateService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserCreateService userCreateService;
  private final UserRepository userRepository;

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto) {
    return userCreateService.save(userDto);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
