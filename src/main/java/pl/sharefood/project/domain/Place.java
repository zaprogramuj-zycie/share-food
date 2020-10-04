package pl.sharefood.project.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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

   @OneToMany(mappedBy = "place")
   private Set<PlaceType> placeTypeSet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float longitude;
    private Float latitude;
    private Long type_id;

    @CreatedDate
    private Date createdAt;
    @Column(nullable = true)
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;
}
