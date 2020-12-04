package pl.zz.sharefood.user.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pl.zz.sharefood.common.mapper.BaseMapper;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.mapper.UserMapper;

@Component
public class UserMapperImpl extends BaseMapper implements UserMapper {

  @Override
  public User userDtoToUser(UserDto userDto) {
    return remapObject(userDto, new User());
  }

  @Override
  public UserDto userToUserDto(User user) {
    return remapObject(user, new UserDto());
  }

  @Override
  public List<UserDto> mapPageUserToListUserDto(Page<User> listUser) {
    List<UserDto> result = new ArrayList<>();
    for (User user : listUser.getContent()) {
      result.add(userToUserDto(user));
    }
    return result;
  }
}
