package pl.zz.sharefood.food.service;

import pl.zz.sharefood.food.dto.FoodBaseDto;

public interface FoodCreateService {

    FoodBaseDto save(FoodBaseDto foodBaseDto);
}
