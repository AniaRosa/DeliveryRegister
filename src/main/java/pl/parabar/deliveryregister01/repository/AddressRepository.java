package pl.parabar.deliveryregister01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parabar.deliveryregister01.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
