package pl.zz.sharefood.mapper;

import org.springframework.stereotype.Component;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.FoodDto;

@Component
public class FoodMapper {

  public FoodDto mapToDto(Food food) {
    return new FoodDto(
        food.getId(),
        food.getName(),
        food.getAmount(),
        food.getExpireAt(),
        food.getUpdatedAt());
  }
}
