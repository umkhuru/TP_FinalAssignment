package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.Rental;

/**
 * Created by student on 2015/10/24.
 */
public interface RentalRepository extends CrudRepository<Rental,Long> {
}
