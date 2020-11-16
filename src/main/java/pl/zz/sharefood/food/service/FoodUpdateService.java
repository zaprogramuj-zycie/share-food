package pl.zz.sharefood.food.service;

import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;

public interface FoodUpdateService {

  FoodBaseDto execute (Food food);

  void updateFoodValues(Food toUpdate, Food food);

}
