package pl.zz.sharefood.food.controller;

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
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.food.service.FoodDeleteService;
import pl.zz.sharefood.food.service.FoodListService;
import pl.zz.sharefood.food.service.FoodCreateService;
import pl.zz.sharefood.food.service.FoodUpdateService;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

  private final FoodListService foodListService;
  private final FoodCreateService foodCreateService;
  private final FoodUpdateService foodUpdateService;
  private final FoodDeleteService foodDeleteService;

  @GetMapping
  public PagedResponseDto<?> listFood(@RequestParam ListPageRequest listPageRequest) {
    return foodListService.execute(listPageRequest);
  }

  @PostMapping
  public Food createFood(@RequestBody Food food) {
    return foodCreateService.save(food);
  }

  @PutMapping
  public FoodDto updateFood(@RequestBody Food food) {
    return foodUpdateService.execute(food);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteFood(@PathVariable Long id) {
    return foodDeleteService.execute(id);
  }
}
