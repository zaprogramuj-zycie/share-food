package pl.zz.sharefood.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.payload.PagedResponse;
import pl.zz.sharefood.requests.ListPageRequest;
import pl.zz.sharefood.service.FoodListService;
import pl.zz.sharefood.service.FoodService;
import pl.zz.sharefood.service.FoodDeleteService;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final FoodListService foodListService;
    private final  FoodDeleteService foodDeleteService;

    @GetMapping
    public PagedResponse<?> getAllFood(@RequestParam ListPageRequest listPageRequest) {
        return foodListService.execute(listPageRequest);
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
