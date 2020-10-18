package pl.zz.sharefood.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.domain.User;
import pl.zz.sharefood.domain.dto.UserDto;
import pl.zz.sharefood.mapper.UserMapper;
import pl.zz.sharefood.repository.UserRepository;
import pl.zz.sharefood.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserRepository userRepository;

    private final UserService userService;

    private final UserMapper userMapper;

/*    @PostMapping
    public User addUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }
*/

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userMapper.userToUserDto(userService.save(userMapper.userDtoToUser(userDto)));
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
