package pl.zz.sharefood.common.mapper;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodDto;

public interface BaseMapper {

  <B, R> R remapObjects(B base, R result);

  Food foodBaseDtoToFood(FoodBaseDto foodBaseDto);

  FoodBaseDto foodToFoodBaseDto(Food food);

  List<FoodDto> mapFoodToFoodDtoList(Page<Food> listFood);


}
