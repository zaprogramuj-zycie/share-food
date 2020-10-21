package pl.zz.sharefood.food.service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.exception.ResourceNotFoundException;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.food.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodUpdateService {

    private final FoodRepository foodRepository;

    public FoodDto execute(Food food) {
        if (Objects.nonNull(food.getId())) {
            Optional<Food> foodOptional = foodRepository.findById(food.getId());
            Food toUpdateFood = foodOptional.orElseThrow(this::getNotFoundException);
            updateFoodValues(toUpdateFood, food);
            return mapToDto(toUpdateFood);
        }
        throw getNotFoundException();
    }

    private ResourceNotFoundException getNotFoundException() {
        return new ResourceNotFoundException("Food not found");
    }

    private void updateFoodValues(Food foodToUpdate, Food food) {
        Date actualDate = new Date();
        foodToUpdate.setName(food.getName());
        foodToUpdate.setAmount(food.getAmount());
        foodToUpdate.setExpireAt(food.getExpireAt());
        foodToUpdate.setUpdatedAt(actualDate);
    }

    public FoodDto mapToDto(Food food) {
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food, foodDto);
        return foodDto;
    }
}

