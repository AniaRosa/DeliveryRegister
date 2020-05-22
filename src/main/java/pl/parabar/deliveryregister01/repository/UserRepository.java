package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
