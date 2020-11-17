package pl.zz.sharefood.user.service.impl;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.mapper.UserMapper;
import pl.zz.sharefood.user.repository.UserRepository;
import pl.zz.sharefood.user.service.UserCreateService;

@RequiredArgsConstructor
@Service
public class UserCreateServiceImpl implements UserCreateService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final BCryptPasswordEncoder encoder;


  @Override
  public UserDto save(UserDto userDto) {
    userDto.setPassword(encoder.encode(userDto.getPassword()));
    userDto.setCreatedAt(new Date());
    return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
  }

}
