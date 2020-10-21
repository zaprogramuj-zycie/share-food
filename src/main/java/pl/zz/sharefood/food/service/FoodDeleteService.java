package pl.zz.sharefood.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.exception.ResourceNotFoundException;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.repository.FoodRepository;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodDeleteService {

    private final FoodRepository foodRepository;

    public ResponseEntity<?> execute(Long id) {
        Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            deleteFood(food);
            return ResponseEntity.ok(true);
        }
        throw new ResourceNotFoundException("Food not found: " + id);
    }

    private void deleteFood(Food food) {
        food.setDeletedAt(new Date());
        foodRepository.save(food);
    }
}
