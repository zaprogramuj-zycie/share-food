package pl.zz.sharefood.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.dto.UserDto;
import pl.zz.sharefood.mapper.UserMapper;
import pl.zz.sharefood.repository.UserRepository;
import pl.zz.sharefood.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private  final UserMapper userMapper;


    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }
}
