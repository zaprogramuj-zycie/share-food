package pl.zz.sharefood.common.builder;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.common.dto.PagedResponseDto;

public class PagedResponseDtoBuilder {

  private List<FoodDto> listFoodDto;
  private Page<Food> foodEntityPage;

  private PagedResponseDtoBuilder() {
  }

  public static PagedResponseDtoBuilder create() {
    return new PagedResponseDtoBuilder();
  }

  public PagedResponseDtoBuilder listFoodDto(List<FoodDto> listFoodDto) {
    this.listFoodDto = listFoodDto;
    return this;
  }

  public PagedResponseDtoBuilder foodEntityPage(Page<Food> foodEntityPage) {
    this.foodEntityPage = foodEntityPage;
    return this;
  }

  public PagedResponseDto<?> build() {
    return new PagedResponseDto<>(
        listFoodDto,
        foodEntityPage.getNumber(),
        foodEntityPage.getSize(),
        foodEntityPage.getTotalElements(),
        foodEntityPage.getTotalPages(),
        foodEntityPage.isLast()
    );
  }
}
