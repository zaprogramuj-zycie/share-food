package pl.zz.sharefood.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zz.sharefood.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
