package pl.zz.sharefood.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.payload.PagedResponse;
import pl.zz.sharefood.requests.ListPageRequest;
import pl.zz.sharefood.service.FoodDeleteService;
import pl.zz.sharefood.service.FoodListService;
import pl.zz.sharefood.service.FoodService;
import pl.zz.sharefood.service.FoodUpdateService;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

  private final FoodService foodService;
  private final FoodListService foodListService;
  private final FoodDeleteService foodDeleteService;
  private final FoodUpdateService foodUpdateService;

  @GetMapping
  public PagedResponse<?> getAllFood(@RequestParam ListPageRequest listPageRequest) {
    return foodListService.execute(listPageRequest);
  }

  @PostMapping
  public Food addFood(@RequestBody Food food) {
    return foodService.save(food);
  }

  @PutMapping
  public FoodDto updateFood(@RequestBody Food food) {
    return foodUpdateService.updateFood(food);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteFood(@PathVariable Long id) {
    return foodDeleteService.foodDeleteService(id);
  }
}
