package pl.zz.sharefood.food.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodCreateService;

@AllArgsConstructor
@Service
public class FoodCreateServiceImpl implements FoodCreateService {

    private final FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
      return foodRepository.save(food);
    }
}
