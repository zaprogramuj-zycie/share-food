package pl.zz.sharefood.food.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.food.mapper.FoodMapper;

@Component
public class FoodMapperImpl implements FoodMapper {

  @Override
  public Food foodBaseDtoToFood(FoodBaseDto foodBaseDto) {
    return Food.builder()
        .name(foodBaseDto.getName())
        .place(foodBaseDto.getPlace())
        .amount(foodBaseDto.getAmount())
        .build();
  }

  @Override
  public FoodBaseDto foodToFoodBaseDto(Food food) {
    return FoodBaseDto.builder()
        .name(food.getName())
        .place(food.getPlace())
        .amount(food.getAmount())
        .build();
  }

  public List<FoodDto> mapFoodToDto(Page<Food> listFood) {
    List<FoodDto> listFoodDto = new ArrayList<>();
    BeanUtils.copyProperties(listFoodDto, listFood.getContent());
    return listFoodDto;
  }
}
