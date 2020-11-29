package pl.zz.sharefood.user.service;

import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;

public interface UserListService {

  PagedResponseDto<?> execute(ListPageRequest listPageRequest);
}
