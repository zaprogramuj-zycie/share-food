package pl.zz.sharefood.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.service.FoodService;

@AllArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
      return foodRepository.save(food);
    }
}
