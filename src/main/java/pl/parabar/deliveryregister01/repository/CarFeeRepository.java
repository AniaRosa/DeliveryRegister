package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.CarFee;

public interface CarFeeRepository extends JpaRepository<CarFee, Long> {
}
