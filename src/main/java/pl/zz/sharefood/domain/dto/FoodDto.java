package pl.zz.sharefood.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zz.sharefood.domain.FoodCategory;
import pl.zz.sharefood.domain.Place;
import pl.zz.sharefood.domain.User;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private String name;
    private Integer amount;
    private Date expireAt;
    private Place place;
    private Set<FoodCategory> foodCategories;
    private User user;

}


