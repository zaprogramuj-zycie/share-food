package pl.zz.sharefood.user.mapper.impl;

import org.springframework.stereotype.Component;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .id(userDto.getId())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .password(userDto.getPassword())
                .createdAt(userDto.getCreatedAt())
                .build();
    }

    @Override
    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
