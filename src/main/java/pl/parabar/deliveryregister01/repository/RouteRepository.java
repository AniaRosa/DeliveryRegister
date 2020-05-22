package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findAllByDate(String date);

    Route findById(long id);

    void deleteById(long id);
}
