package pl.zz.sharefood.place.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import pl.zz.sharefood.placetype.domain.PlaceType;
import pl.zz.sharefood.food.domain.Food;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float longitude;
    private Float latitude;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private PlaceType placeType;

    @OneToMany(mappedBy = "place")
    private Set<Food> foods;

    @CreatedDate
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
