package pl.sharefood.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sharefood.project.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Override
  User save(User user);

  @Override
  List<User> findAll();

  @Override
  Optional<User> findById(Long id);

  @Override
  void deleteAll();

  @Override
  void deleteById(Long id);
}
