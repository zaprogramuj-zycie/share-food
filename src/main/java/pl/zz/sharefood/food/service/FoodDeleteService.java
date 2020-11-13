package pl.zz.sharefood.food.service;

import org.springframework.http.ResponseEntity;
import pl.zz.sharefood.food.domain.Food;

public interface FoodDeleteService {

  ResponseEntity<?> execute(Long id);

  void deleteFood(Food food);

}
