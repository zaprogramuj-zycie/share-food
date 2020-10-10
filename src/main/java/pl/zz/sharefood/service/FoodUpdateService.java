package pl.zz.sharefood.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

  private final FoodRepository foodRepository;

  public Food updateFood(Food newFood, Long id) {
    return foodRepository.findById(id)
        .map(food -> {
          food.setId(newFood.getId());
          food.setName(newFood.getName());
          food.setAmount(newFood.getAmount());
          food.setExpireAt(newFood.getExpireAt());
          food.setUpdatedAt(newFood.getUpdatedAt());
          return foodRepository.save(food);
        }).orElseGet(() -> {
          newFood.setId(id);
          return foodRepository.save(newFood);
        });
  }
}
