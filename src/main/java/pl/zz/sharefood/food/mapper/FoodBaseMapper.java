package pl.zz.sharefood.food.mapper;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodDto;

public interface FoodBaseMapper {

  Food foodBaseDtoToFood(FoodBaseDto foodBaseDto);

  FoodBaseDto foodToFoodBaseDto(Food food);

  List<FoodDto> mapFoodToDto(Page<Food> listFood);
  
  <B, R> R remapObjects(B base, R result);
}
