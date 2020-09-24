package pl.sharefood.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sharefood.project.domain.Food;
import pl.sharefood.project.repository.FoodRepository;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
  @Autowired
  private FoodRepository foodRepository;

  @GetMapping
  public List<Food> getAllFood () {
    return foodRepository.findAll();
  }
  @PostMapping
  public Food addFood(@RequestBody Food food) {
    foodRepository.save(food);
    return food;
  }
  @DeleteMapping("/{id}")
  public void deleteFood(@PathVariable Long id) {
    foodRepository.deleteById(id);
  }
}
