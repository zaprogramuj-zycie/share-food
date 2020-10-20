package pl.zz.sharefood.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zz.sharefood.domain.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

  Page<Food> findAll(Pageable pageable);
}
