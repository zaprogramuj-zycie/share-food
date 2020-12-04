package pl.zz.sharefood.user.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.service.ListServiceAbstract;
import pl.zz.sharefood.user.builder.UserPagedResponseDtoBuilder;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.mapper.UserMapper;
import pl.zz.sharefood.user.repository.UserRepository;
import pl.zz.sharefood.user.service.UserListService;

@Service
@RequiredArgsConstructor
public class UserListServiceImpl extends ListServiceAbstract<User, UserDto> implements UserListService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  protected Page<User> getEntities(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  protected List<UserDto> getDtos(Page<User> listEntities) {
    return userMapper.mapPageUserToListUserDto(listEntities);
  }

  @Override
  protected PagedResponseDto<?> getPagedResponse(Page<User> listPage, List<UserDto> listDtos) {
    return UserPagedResponseDtoBuilder.create()
        .listUserDto(listDtos)
        .userEntityPage(listPage)
        .build();
  }
}
