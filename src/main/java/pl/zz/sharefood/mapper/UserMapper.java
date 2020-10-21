package pl.zz.sharefood.mapper;

import pl.zz.sharefood.domain.User;
import pl.zz.sharefood.domain.dto.UserDto;

public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
