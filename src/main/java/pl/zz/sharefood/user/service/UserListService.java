package pl.zz.sharefood.user.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;

public interface UserListService {

  PagedResponseDto<?> execute(ListPageRequest listPageRequest);

  List<UserDto> mapUserToDto (Page<User> listUser);

}
