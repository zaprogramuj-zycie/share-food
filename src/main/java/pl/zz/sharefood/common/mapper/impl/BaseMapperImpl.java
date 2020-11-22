package pl.zz.sharefood.common.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.mapper.BaseMapper;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodDto;

public class BaseMapperImpl implements BaseMapper {

  @Override
  public Food foodBaseDtoToFood(FoodBaseDto foodBaseDto) {
    return remapObjects(foodBaseDto, new Food());
  }

  @Override
  public FoodBaseDto foodToFoodBaseDto(Food food) {
    return remapObjects(food, new FoodBaseDto());
  }

  @Override
  public List<FoodDto> mapFoodToFoodDtoList(Page<Food> listFood) {
    ArrayList<FoodDto> theList = new ArrayList<>();
    remapObjects(listFood, theList);
    BeanUtils.copyProperties(listFood, theList);
    return theList;
  }

  @Override
  public <B, R> R remapObjects(B base, R result) {
    BeanUtils.copyProperties(base, result);
    return result;
  }
}
