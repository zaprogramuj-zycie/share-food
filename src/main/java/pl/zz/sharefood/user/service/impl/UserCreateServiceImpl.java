package pl.zz.sharefood.user.service.impl;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.user.domain.User;
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

  public UserDto execute(UserDto userDto) {
    modifyUserDtoData(userDto);
    User savedUser = save(userDto);
    return userMapper.userToUserDto(savedUser);
  }


  private User save(UserDto userDto) {
    return userRepository.save(userMapper.userDtoToUser(userDto));
  }

  private void modifyUserDtoData(UserDto userDto) {
    userDto.setPassword(encoder.encode(userDto.getPassword()));
    userDto.setCreatedAt(new Date());
  }
}
