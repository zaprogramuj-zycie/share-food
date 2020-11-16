package pl.zz.sharefood.food.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.common.builder.PagedResponseDtoBuilder;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.food.mapper.FoodMapper;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodListService;

@Service
@RequiredArgsConstructor
public class FoodListServiceImpl implements FoodListService {

  private final FoodRepository foodRepository;
  private final FoodMapper foodMapper;

  @Override
  public PagedResponseDto<?> execute(ListPageRequest listPageRequest) {

    Pageable pageable = PageRequest.of(listPageRequest.getSize(), listPageRequest.getPage());
    Page<Food> listFood = foodRepository.findAll(pageable);
    List<FoodDto> listFoodDto = foodMapper.mapFoodToDto(listFood);

    return PagedResponseDtoBuilder.create()
        .listFoodDto(listFoodDto)
        .foodEntityPage(listFood)
        .buildListFood();
  }
}
