package pl.zz.sharefood.user.builder;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.builder.PagedResponseDtoBuilder;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;

public class UserPagedResponseDtoBuilder extends PagedResponseDtoBuilder<User, UserDto> {

  private UserPagedResponseDtoBuilder() {
  }

  public static UserPagedResponseDtoBuilder create() {
    return new UserPagedResponseDtoBuilder();
  }

  public UserPagedResponseDtoBuilder listUserDto(List<UserDto> listUserDto) {
    this.listDtos = listUserDto;
    return this;
  }

  public UserPagedResponseDtoBuilder userEntityPage(Page<User> userEntityPage) {
    this.entityPage = userEntityPage;
    return this;
  }
}
