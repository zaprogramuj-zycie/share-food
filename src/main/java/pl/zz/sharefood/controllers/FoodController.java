package pl.zz.sharefood.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.service.FoodService;
import pl.zz.sharefood.service.FoodDeleteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {


    private final FoodRepository foodRepository;

    private final FoodService foodService;

    final private FoodDeleteService foodDeleteService;
    
    @GetMapping
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
       return foodService.save(food);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteFood(@PathVariable Long id) {
        return foodDeleteService.foodDeleteService(id);
    }
}
