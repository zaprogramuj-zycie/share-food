package pl.zz.sharefood.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.exception.ResourceNotFoundException;
import pl.zz.sharefood.repository.FoodRepository;

@Service
public class FoodDeleteService {

  private final FoodRepository foodRepository;

  FoodDeleteService(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  public ResponseEntity<?> foodDeleteService(Long id) {
    Optional<Food> foundFood = Optional.ofNullable(foodRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Food", "ID", id)));

    Date currentDate = new Date();
    foundFood.get().setDeletedAt(currentDate);
    foodRepository.save(foundFood.get());

    return ResponseEntity.ok(currentDate);
  }
}
