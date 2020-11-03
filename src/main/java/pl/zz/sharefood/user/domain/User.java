package pl.zz.sharefood.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import pl.zz.sharefood.food.domain.Food;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Food> foods;

    @CreatedDate
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}


