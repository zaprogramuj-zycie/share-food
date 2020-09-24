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

//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(name = "food_place",
//          joinColumns = {@JoinColumn(name = "food_id")},
//          inverseJoinColumns = {@JoinColumn(name = "place_id")})
//  private Set<Place> places = new HashSet<>();

//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(name = "food_category",
//          joinColumns = {@JoinColumn(name = "food_id")},
//          inverseJoinColumns = {@JoinColumn(name = "category_id")})
//  private Set<FoodCategory> foodCategories = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_food",
          joinColumns = {@JoinColumn(name = "food_id")},
          inverseJoinColumns = {@JoinColumn(name = "user_id")})
  private Set<User> users;

  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;
}
