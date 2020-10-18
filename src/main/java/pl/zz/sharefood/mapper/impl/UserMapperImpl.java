package pl.zz.sharefood.mapper.impl;

import org.springframework.stereotype.Component;
import pl.zz.sharefood.domain.User;
import pl.zz.sharefood.domain.dto.UserDto;
import pl.zz.sharefood.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .id(userDto.getId())
                .password(userDto.getPassword())
                .build();
    }

    @Override
    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
