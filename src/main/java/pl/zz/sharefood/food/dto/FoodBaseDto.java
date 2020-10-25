package pl.zz.sharefood.food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zz.sharefood.foodcategory.domain.FoodCategory;
import pl.zz.sharefood.place.domain.Place;
import pl.zz.sharefood.user.domain.User;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodBaseDto {

    private String name;
    private Integer amount;
    private Date expireAt;
    private Place place;
    private Set<FoodCategory> foodCategories;
    private User user;
}