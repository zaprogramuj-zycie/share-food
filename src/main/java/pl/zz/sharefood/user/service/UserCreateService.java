package pl.zz.sharefood.user.service;

import pl.zz.sharefood.user.dto.UserDto;

public interface UserCreateService {

    UserDto execute(UserDto userDto);
}
