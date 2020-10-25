package pl.zz.sharefood.food.mapper.impl;

import org.springframework.stereotype.Component;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;

@Component
public class FoodMapper implements pl.zz.sharefood.food.mapper.FoodMapper {

    @Override
    public Food foodBaseDtoToFood(FoodBaseDto foodBaseDto) {
        return Food.builder()
                .name(foodBaseDto.getName())
                .place(foodBaseDto.getPlace())
                .amount(foodBaseDto.getAmount())
                .build();
    }

    @Override
    public FoodBaseDto foodToFoodBaseDto(Food food) {
        return FoodBaseDto.builder()
                .name(food.getName())
                .place(food.getPlace())
                .amount(food.getAmount())
                .build();
    }
}
