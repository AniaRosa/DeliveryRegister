package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.CarFee;

import java.util.List;

public interface CarFeeRepository extends JpaRepository<CarFee, Long> {

    List<CarFee> findAllByDate(String date);

    List<CarFee> findAllByDateBetween(String date1, String date2);

    List<CarFee> findAllByDateContaining(int year);

    List<CarFee> findAll();

    CarFee findById(long id);

    void deleteById(long id);
}
