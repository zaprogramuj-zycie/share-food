package pl.sharefood.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sharefood.project.domain.Food;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

  @Override
  Food save(Food food);

  @Override
  List<Food> findAll();

  @Override
  Optional<Food> findById(Long id);

  @Override
  void deleteById(Long id);

  @Override
  void deleteAll();
}
