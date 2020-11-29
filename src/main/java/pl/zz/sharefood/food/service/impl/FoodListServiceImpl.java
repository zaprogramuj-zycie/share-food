package pl.zz.sharefood.food.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.service.ListServiceAbstract;
import pl.zz.sharefood.food.builder.FoodPagedResponseDtoBuilder;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.mapper.FoodMapper;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.FoodListService;

@Service
@RequiredArgsConstructor
public class FoodListServiceImpl extends ListServiceAbstract<Food, FoodBaseDto> implements FoodListService {

  private final FoodRepository foodRepository;
  private final FoodMapper foodMapper;

  @Override
  protected Page<Food> getEntities(Pageable pageable) {
    return foodRepository.findAll(pageable);
  }

  @Override
  protected List<FoodBaseDto> getDtos(Page<Food> listEntities) {
    return foodMapper.mapPageFoodToListFoodDto(listEntities);
  }

  @Override
  protected PagedResponseDto<?> getPagedResponse(Page<Food> listPage, List<FoodBaseDto> listDtos) {
    return FoodPagedResponseDtoBuilder.create()
        .listFoodDto(listDtos)
        .foodEntityPage(listPage)
        .build();
  }
}