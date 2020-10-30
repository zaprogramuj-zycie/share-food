package pl.zz.sharefood.food.mapper;

import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;

public interface FoodMapper {

    Food foodBaseDtoToFood(FoodBaseDto foodBaseDto);

    FoodBaseDto foodToFoodBaseDto(Food food);
}
