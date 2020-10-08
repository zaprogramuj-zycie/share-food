package pl.zz.sharefood.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.service.FoodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {


    private final FoodRepository foodRepository;

    private final FoodService foodService;

    @GetMapping
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
       return foodService.save(food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
    }
}
