package pl.zz.sharefood.food.service;

import pl.zz.sharefood.food.dto.FoodCreateDto;

public interface FoodCreateService {

  FoodCreateDto save(FoodCreateDto foodCreateDto);
}
