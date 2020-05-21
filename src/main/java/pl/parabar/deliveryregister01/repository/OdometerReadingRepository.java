package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.Address;
import pl.parabar.deliveryregister01.entity.OdometerReading;

import java.util.List;

public interface OdometerReadingRepository extends JpaRepository<OdometerReading, Long> {

    List<OdometerReading> findAllByDate(String date);

    OdometerReading findById(long id);

    void deleteById(long id);
}
