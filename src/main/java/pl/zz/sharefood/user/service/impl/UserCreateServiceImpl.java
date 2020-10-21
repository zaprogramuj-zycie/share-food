package pl.zz.sharefood.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.mapper.UserMapper;
import pl.zz.sharefood.user.repository.UserRepository;
import pl.zz.sharefood.user.service.UserCreateService;

@RequiredArgsConstructor
@Service
public class UserCreateServiceImpl implements UserCreateService {

    private final UserRepository userRepository;

    private  final UserMapper userMapper;


    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }
}
