package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.Refuel;

import java.util.List;

public interface RefuelRepository extends JpaRepository<Refuel, Long> {

    List<Refuel> findAllByDate(String date);

    Refuel findById(long id);

    void deleteById(long id);
}
