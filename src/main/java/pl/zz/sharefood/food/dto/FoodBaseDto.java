package pl.zz.sharefood.food.dto;

import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import pl.zz.sharefood.foodcategory.domain.FoodCategory;
import pl.zz.sharefood.place.domain.Place;
import pl.zz.sharefood.user.domain.User;

@Getter
@Setter
public class FoodBaseDto {

  private String name;
  private Integer amount;
  private Date expireAt;
  private Place place;
  private Set<FoodCategory> foodCategories;
  private User user;
}