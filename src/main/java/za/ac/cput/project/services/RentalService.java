package za.ac.cput.project.services;

import za.ac.cput.project.domain.PaymentMethod;
import za.ac.cput.project.domain.Rental;

import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
public interface RentalService {

    public List<Rental> getRentals();
}
