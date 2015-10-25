package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.PaymentMethod;

/**
 * Created by student on 2015/10/24.
 */
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
}
