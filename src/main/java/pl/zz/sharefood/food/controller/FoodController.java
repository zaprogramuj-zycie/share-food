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
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.food.service.impl.FoodDeleteServiceImpl;
import pl.zz.sharefood.food.service.impl.FoodListServiceImpl;
import pl.zz.sharefood.food.service.FoodCreateService;
import pl.zz.sharefood.food.service.impl.FoodUpdateServiceImpl;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

  private final FoodListServiceImpl foodListServiceImpl;
  private final FoodCreateService foodCreateService;
  private final FoodUpdateServiceImpl foodUpdateServiceImpl;
  private final FoodDeleteServiceImpl foodDeleteServiceImpl;

  @GetMapping
  public PagedResponseDto<?> listFood(@RequestParam ListPageRequest listPageRequest) {
    return foodListServiceImpl.execute(listPageRequest);
  }

  @PostMapping
  public FoodBaseDto createFood(@RequestBody FoodBaseDto foodBaseDto) {
    return foodCreateService.save(foodBaseDto);
  }

  @PutMapping
  public FoodBaseDto updateFood(@RequestBody Food food) {
    return foodUpdateServiceImpl.execute(food);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> deleteFood(@PathVariable Long id) {
    return foodDeleteServiceImpl.execute(id);
  }
}
