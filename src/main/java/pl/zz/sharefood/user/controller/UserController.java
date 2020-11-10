package pl.zz.sharefood.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.repository.UserRepository;
import pl.zz.sharefood.user.service.UserCreateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserCreateService userCreateService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userCreateService.save(userDto);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
