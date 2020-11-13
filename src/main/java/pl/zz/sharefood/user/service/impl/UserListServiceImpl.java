package pl.zz.sharefood.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.common.builder.PagedResponseDtoBuilder;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;
import pl.zz.sharefood.user.repository.UserRepository;
import pl.zz.sharefood.user.service.UserListService;

@Service
@RequiredArgsConstructor
public class UserListServiceImpl implements UserListService {

  private final UserRepository userRepository;

  public PagedResponseDto<?> execute(ListPageRequest listPageRequest) {
    Pageable pageable = PageRequest.of(listPageRequest.getSize(), listPageRequest.getPage());
    Page<User> listUser = userRepository.findAll(pageable);
    List<UserDto> listUserDto = mapUserToDto(listUser);

    return PagedResponseDtoBuilder.create()
        .listUserDto(listUserDto)
        .userEntityPage(listUser)
        .buildListUser();
  }

  public List<UserDto> mapUserToDto(Page<User> listUser) {
    List<UserDto> listUserDto = new ArrayList<>();
    BeanUtils.copyProperties(listUserDto, listUser.getContent());
    return listUserDto;
  }
}
