package pl.zz.sharefood.food.service;

import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodDto;

public interface FoodUpdateService {

  FoodDto execute (Food food);

  void updateFoodValues(Food toUpdate, Food food);

  FoodDto mapToDto(Food food);

}
