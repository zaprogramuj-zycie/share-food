package pl.sharefood.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private Integer amount;
  private Date expireAt;
  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;

  @ManyToMany
  @JoinTable(name = "food_place",
          joinColumns = {@JoinColumn(name = "food_id")},
          inverseJoinColumns = {@JoinColumn(name = "place_id")})
  private Set<Place> places;

  @ManyToMany
  @JoinTable(name = "food_categories",
          joinColumns = {@JoinColumn(name = "food_id")},
          inverseJoinColumns = {@JoinColumn(name = "category_id")})
  private Set<FoodCategory> foodCategories;

  @ManyToMany
  @JoinTable(name = "food_user",
          joinColumns = {@JoinColumn(name = "food_id")},
          inverseJoinColumns = {@JoinColumn(name = "user_id")})
  private Set<User> users;
}
