package pl.zz.sharefood.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer amount;
  private Date expireAt;

  @ManyToOne
  @JoinColumn(name = "place_id")
  private Place place;

  @ManyToMany
  @JoinTable(name = "foods_categories",
          joinColumns = {@JoinColumn(name = "food_id")},
          inverseJoinColumns = {@JoinColumn(name = "category_id")})
  private Set<FoodCategory> foodCategories;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @CreatedDate
  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;
}
