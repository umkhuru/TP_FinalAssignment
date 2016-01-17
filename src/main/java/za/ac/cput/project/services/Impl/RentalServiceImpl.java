package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Override
    public Rental findById(Long id) {
        return repository.findOne(id);
    }
    @Override
    public Rental save(Rental entity) {
        return repository.save(entity);
    }
    @Override
    public Rental update(Rental entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Rental entity) {repository.delete(entity);}

    public List<Rental> findAll() {
        List<Rental> allRentals = new ArrayList<Rental>();

        Iterable<Rental> rentals = repository.findAll();
        for(Rental rental: rentals)
        {
            allRentals.add(rental);
        }
        return allRentals;
    }

}
