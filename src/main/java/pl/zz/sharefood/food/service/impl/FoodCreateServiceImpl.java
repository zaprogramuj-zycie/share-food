package pl.zz.sharefood.food.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.mapper.FoodMapper;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodCreateService;
@RequiredArgsConstructor
@Service
public class FoodCreateServiceImpl implements FoodCreateService {

    private final FoodRepository foodRepository;

    private final FoodMapper foodMapper;

    @Override
    public FoodBaseDto save(FoodBaseDto foodBaseDto) {
        return foodMapper.foodToFoodBaseDto(foodRepository.save(foodMapper.foodBaseDtoToFood(foodBaseDto)));
    }
}
