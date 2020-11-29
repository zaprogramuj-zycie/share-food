package pl.zz.sharefood.food.mapper;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodCreateDto;
import pl.zz.sharefood.food.dto.FoodListDto;
import pl.zz.sharefood.food.dto.FoodUpdateDto;

public interface FoodMapper {

  Food foodCreateDtoToFood(FoodCreateDto foodCreateDto);

  FoodCreateDto foodToFoodCreateDto(Food food);

  void foodUpdateDtoToFood(FoodUpdateDto foodUpdateDto, Food food);

  FoodUpdateDto foodToFoodUpdateDto(Food food);

  FoodListDto foodToFoodListDto(Food food);

  List<FoodBaseDto> mapPageFoodToListFoodDto(Page<Food> listFood);
}
