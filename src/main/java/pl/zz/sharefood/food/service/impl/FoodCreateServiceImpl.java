package pl.zz.sharefood.food.service.impl;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodCreateDto;
import pl.zz.sharefood.food.mapper.FoodMapper;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodCreateService;

@Service
@RequiredArgsConstructor
public class FoodCreateServiceImpl implements FoodCreateService {

  private final FoodRepository foodRepository;
  private final FoodMapper foodMapper;

  @Override
  public FoodCreateDto save(FoodCreateDto foodCreateDto) {
    Food food = prepareAndGetFood(foodCreateDto);
    Food save = foodRepository.save(food);
    return foodMapper.foodToFoodCreateDto(save);
  }

  private Food prepareAndGetFood(FoodCreateDto foodCreateDto) {
    Food food = foodMapper.foodCreateDtoToFood(foodCreateDto);
    food.setCreatedAt(new Date());
    return food;
  }

}
