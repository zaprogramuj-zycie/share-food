package pl.zz.sharefood.service;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.exception.ResourceNotFoundException;
import pl.zz.sharefood.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

  private final FoodRepository foodRepository;

  public FoodDto updateFood(Food food) {
    if (food.getId() != null) {
      Food toUpdateFood = foodRepository.findById(food.getId())
          .orElseThrow(() -> new ResourceNotFoundException("Not found"));
      updateFoodValues(toUpdateFood, food);
      return mapToDto(toUpdateFood);
    }
    throw new ResourceNotFoundException("Not found");
  }

  private void updateFoodValues(Food foodToUpdate, Food food) {
    Date actualDate = new Date();
    foodToUpdate.setName(food.getName());
    foodToUpdate.setAmount(food.getAmount());
    foodToUpdate.setExpireAt(food.getExpireAt());
    foodToUpdate.setUpdatedAt(actualDate);
  }

  public FoodDto mapToDto(Food food) {
    FoodDto foodDto = new FoodDto();
    BeanUtils.copyProperties(food, foodDto);
    return foodDto;
  }
}

