package pl.zz.sharefood.food.service;

import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;

public interface FoodListService {

  PagedResponseDto<?> execute(ListPageRequest listPageRequest);

}
