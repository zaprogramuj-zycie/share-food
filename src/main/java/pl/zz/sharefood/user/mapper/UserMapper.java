package pl.zz.sharefood.user.mapper;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;

public interface UserMapper {

  User userDtoToUser(UserDto userDto);

  UserDto userToUserDto(User user);

  List<UserDto> mapPageUserToListUserDto(Page<User> listUser);
}
