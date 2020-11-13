package pl.zz.sharefood.food.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodDto;

public interface FoodListService {

  PagedResponseDto<?> execute(ListPageRequest listPageRequest);

  List<FoodDto> mapFoodToDto (Page<Food> listFood);

}
