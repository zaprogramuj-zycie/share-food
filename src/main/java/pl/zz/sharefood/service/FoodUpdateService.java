package pl.zz.sharefood.service;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

  private final FoodRepository foodRepository;

  public Food updateFood(Food newFood, Long id) {
    Date actualDate = new Date();
    return foodRepository.findById(id)
        .map(food -> {
          food.setName(newFood.getName());
          food.setAmount(newFood.getAmount());
          food.setExpireAt(newFood.getExpireAt());
          food.setUpdatedAt(actualDate);
          return foodRepository.save(food);
        }).orElseGet(() -> {
          newFood.setId(id);
          return foodRepository.save(newFood);
        });
  }
}
