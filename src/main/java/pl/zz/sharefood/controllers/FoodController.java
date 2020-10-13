package pl.zz.sharefood.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.payload.PagedResponse;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.service.FoodGetService;
import pl.zz.sharefood.service.FoodService;
import pl.zz.sharefood.service.FoodDeleteService;
import pl.zz.sharefood.util.AppConstants;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {



    private final FoodService foodService;

    private final FoodGetService foodGetService;

    private final  FoodDeleteService foodDeleteService;

    FoodController(FoodDeleteService foodDeleteService, FoodGetService foodGetService, FoodService foodService){
        this.foodDeleteService = foodDeleteService;
        this.foodGetService = foodGetService;
        this.foodService = foodService;
    }
    
    @GetMapping
    public PagedResponse<FoodDto> getAllFood(@RequestBody List<String> foodList,
                                             @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                             @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return foodGetService.getFood(foodList, page, size);
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
