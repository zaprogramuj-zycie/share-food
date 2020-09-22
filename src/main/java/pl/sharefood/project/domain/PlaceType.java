package pl.sharefood.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlaceType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String key;
    private String symbol;

    @CreatedDate
    private Date createdAt;
    @Column(nullable = true)
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;

}
