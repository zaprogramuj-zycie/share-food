package pl.zz.sharefood.food.service.impl;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.common.exception.ResourceNotFoundException;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodUpdateDto;
import pl.zz.sharefood.food.mapper.FoodMapper;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodUpdateService;

@Service
@RequiredArgsConstructor
public class FoodUpdateServiceImpl implements FoodUpdateService {

  private final FoodMapper foodMapper;
  private final FoodRepository foodRepository;

  public FoodUpdateDto execute(FoodUpdateDto foodUpdateDto) {
    if (Objects.nonNull(foodUpdateDto.getId())) {
      Food food = getFood(foodUpdateDto);
      remapFoodUpdateDtoToFood(food, foodUpdateDto);
      foodRepository.save(food);
      return foodMapper.foodToFoodUpdateDto(food);
    }
    throw getNotFoundException();
  }

  private Food getFood(FoodUpdateDto foodUpdateDto) {
    Optional<Food> foodOptional = foodRepository.findById(foodUpdateDto.getId());
    return foodOptional.orElseThrow(this::getNotFoundException);
  }

  public void remapFoodUpdateDtoToFood(Food food, FoodUpdateDto foodUpdateDto) {
    foodMapper.foodUpdateDtoToFood(foodUpdateDto, food);
    food.setUpdatedAt(new Date());
  }

  private ResourceNotFoundException getNotFoundException() {
    return new ResourceNotFoundException("Food not found");
  }
}

