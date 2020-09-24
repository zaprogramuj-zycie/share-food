package pl.sharefood.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategory {

    @ManyToMany(mappedBy = "foodCategories")
    private Set<Food> foods;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String key_;

    @CreatedDate
    private Date createdAt;
    @Column(nullable = true)
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;
}
