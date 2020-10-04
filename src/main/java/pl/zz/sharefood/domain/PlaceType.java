package pl.zz.sharefood.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PlaceType {

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Place place;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String key_;
    private String symbol;

    @CreatedDate
    private Date createdAt;
    @Column(nullable = true)
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;


}
