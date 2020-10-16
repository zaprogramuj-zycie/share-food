package pl.zz.sharefood.domain;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.payload.PagedResponse;

public class PagedResponseBuilder {

  private List<FoodDto> listFoodDto;
  private Page<Food> foodEntityPage;

  private PagedResponseBuilder() {
  }

  public static PagedResponseBuilder create() {
    return new PagedResponseBuilder();
  }

  public PagedResponseBuilder listFoodDto(List<FoodDto> listFoodDto) {
    this.listFoodDto = listFoodDto;
    return this;
  }

  public PagedResponseBuilder foodEntityPage(Page<Food> foodEntityPage) {
    this.foodEntityPage = foodEntityPage;
    return this;
  }

  public PagedResponse<?> build() {
    return new PagedResponse<>(
        listFoodDto,
        foodEntityPage.getNumber(),
        foodEntityPage.getSize(),
        foodEntityPage.getTotalElements(),
        foodEntityPage.getTotalPages(),
        foodEntityPage.isLast()
    );
  }
}
