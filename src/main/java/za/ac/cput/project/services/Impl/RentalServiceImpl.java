package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.PaymentMethod;
import za.ac.cput.project.domain.Rental;
import za.ac.cput.project.repository.RentalRepository;
import za.ac.cput.project.services.RentalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@Service
public class RentalServiceImpl implements RentalService{

    @Autowired
    RentalRepository repository;

    public List<Rental> getRentals() {
        List<Rental> allRentals = new ArrayList<Rental>();

        Iterable<Rental> rentals = repository.findAll();
        for(Rental rental: rentals)
        {
            allRentals.add(rental);
        }
        return allRentals;
    }

}
