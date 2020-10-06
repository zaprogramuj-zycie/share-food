package pl.zz.sharefood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.service.FoodDeleteService;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    final private FoodDeleteService foodDeleteService;

    FoodController(FoodDeleteService foodDeleteService){
        this.foodDeleteService =foodDeleteService;
    }


    @GetMapping
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
        foodRepository.save(food);
        return food;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteFood(@PathVariable Long id) {
        return foodDeleteService.foodDeleteService(id);
    }
}
