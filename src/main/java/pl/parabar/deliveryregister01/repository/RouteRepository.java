package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.Address;
import pl.parabar.deliveryregister01.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
