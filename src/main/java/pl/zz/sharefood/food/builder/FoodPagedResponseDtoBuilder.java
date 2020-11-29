package pl.zz.sharefood.food.builder;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.builder.PagedResponseDtoBuilder;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;

public class FoodPagedResponseDtoBuilder extends PagedResponseDtoBuilder<Food, FoodBaseDto> {

  private FoodPagedResponseDtoBuilder() {
  }

  public static FoodPagedResponseDtoBuilder create() {
    return new FoodPagedResponseDtoBuilder();
  }

  public FoodPagedResponseDtoBuilder listFoodDto(List<FoodBaseDto> listFoodDto) {
    this.listDtos = listFoodDto;
    return this;
  }

  public FoodPagedResponseDtoBuilder foodEntityPage(Page<Food> foodEntityPage) {
    this.entityPage = foodEntityPage;
    return this;
  }
}
