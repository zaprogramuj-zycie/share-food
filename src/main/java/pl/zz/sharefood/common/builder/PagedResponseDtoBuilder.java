package pl.zz.sharefood.common.builder;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodDto;
import pl.zz.sharefood.user.domain.User;
import pl.zz.sharefood.user.dto.UserDto;

public class PagedResponseDtoBuilder {

  private List<FoodDto> listFoodDto;
  private Page<Food> foodEntityPage;
  private List<UserDto> listUserDto;
  private Page<User> userEntityPage;

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

  public PagedResponseDto<?> buildListFood() {
    return new PagedResponseDto<>(
        listFoodDto,
        foodEntityPage.getNumber(),
        foodEntityPage.getSize(),
        foodEntityPage.getTotalElements(),
        foodEntityPage.getTotalPages(),
        foodEntityPage.isLast()
    );
  }

  public PagedResponseDtoBuilder listUserDto(List<UserDto> listUserDto) {
    this.listUserDto = listUserDto;
    return this;
  }

  public PagedResponseDtoBuilder userEntityPage(Page<User> userEntityPage) {
    this.userEntityPage = userEntityPage;
    return this;
  }

  public PagedResponseDto<?> buildListUser() {
    return new PagedResponseDto<>(
        listUserDto,
        userEntityPage.getNumber(),
        userEntityPage.getSize(),
        userEntityPage.getTotalElements(),
        userEntityPage.getTotalPages(),
        userEntityPage.isLast()
    );
  }
}
