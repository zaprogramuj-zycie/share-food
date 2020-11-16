package pl.zz.sharefood.food.service.impl;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.exception.ResourceNotFoundException;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.food.mapper.FoodMapper;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodUpdateService;

@Service
@RequiredArgsConstructor
public class FoodUpdateServiceImpl implements FoodUpdateService {

  private final FoodRepository foodRepository;

  private final FoodMapper foodMapper;

  public FoodBaseDto execute(Food food) {
    if (Objects.nonNull(food.getId())) {
      Optional<Food> foodOptional = foodRepository.findById(food.getId());
      Food toUpdateFood = foodOptional.orElseThrow(this::getNotFoundException);
      updateFoodValues(toUpdateFood, food);
      return foodMapper.foodToFoodBaseDto(toUpdateFood);
    }
    throw getNotFoundException();
  }

  private ResourceNotFoundException getNotFoundException() {
    return new ResourceNotFoundException("Food not found");
  }

  public void updateFoodValues(Food foodToUpdate, Food food) {
    Date actualDate = new Date();
    foodToUpdate.setName(food.getName());
    foodToUpdate.setAmount(food.getAmount());
    foodToUpdate.setExpireAt(food.getExpireAt());
    foodToUpdate.setUpdatedAt(actualDate);
  }
}

