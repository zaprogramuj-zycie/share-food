package pl.zz.sharefood.food.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pl.zz.sharefood.common.mapper.BaseMapper;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodCreateDto;
import pl.zz.sharefood.food.dto.FoodListDto;
import pl.zz.sharefood.food.dto.FoodUpdateDto;
import pl.zz.sharefood.food.mapper.FoodMapper;

@Component
public class FoodMapperImpl extends BaseMapper implements FoodMapper {

  @Override
  public Food foodCreateDtoToFood(FoodCreateDto foodCreateDto) {
    return remapObject(foodCreateDto, new Food());
  }

  @Override
  public FoodCreateDto foodToFoodCreateDto(Food food) {
    return remapObject(food, new FoodCreateDto());
  }

  @Override
  public void foodUpdateDtoToFood(FoodUpdateDto foodUpdateDto, Food food) {
    remapObject(foodUpdateDto, food);
  }

  @Override
  public FoodUpdateDto foodToFoodUpdateDto(Food food) {
    return remapObject(food, new FoodUpdateDto());
  }

  @Override
  public FoodListDto foodToFoodListDto(Food food) {
    return remapObject(food, new FoodListDto());
  }

  @Override
  public List<FoodBaseDto> mapPageFoodToListFoodDto(Page<Food> listFood) {
    List<FoodBaseDto> result = new ArrayList<>();
    for (Food food : listFood.getContent()) {
      result.add(foodToFoodListDto(food));
    }
    return result;
  }
}
