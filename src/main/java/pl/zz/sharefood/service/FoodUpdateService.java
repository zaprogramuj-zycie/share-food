package pl.zz.sharefood.service;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.FoodDto;
import pl.zz.sharefood.exception.ResourceNotFoundException;
import pl.zz.sharefood.mapper.FoodMapper;
import pl.zz.sharefood.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

  private final FoodRepository foodRepository;
  private final FoodMapper foodMapper;

  public FoodDto updateFood(Food foodToUpdate) {

    if (foodToUpdate.getId() != null) {
      Food food = foodRepository.findById(foodToUpdate.getId())
          .orElseThrow(() -> new ResourceNotFoundException(
              "Not found"));
      updateFoodValues(food, foodToUpdate);
      return foodMapper.mapToDto(foodToUpdate);
    }
    throw new ResourceNotFoundException("Not found");
  }

  private void updateFoodValues(Food food, Food foodToUpdate) {
    Date actualDate = new Date();
    food.setName(foodToUpdate.getName());
    food.setAmount(foodToUpdate.getAmount());
    food.setExpireAt(foodToUpdate.getExpireAt());
    food.setUpdatedAt(actualDate);
  }

}
