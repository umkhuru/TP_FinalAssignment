package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Transportation;
import za.ac.cput.project.repository.TransportationRepository;
import za.ac.cput.project.services.ExoticCarsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/17.
 */
@Service
public class ExoticCarsServiceImpl implements ExoticCarsService{

    @Autowired
    TransportationRepository repository;
    @Override
    public Transportation findById(Long id) {
        return repository.findOne(id);
    }
    @Override
    public Transportation save(Transportation entity) {
        return repository.save(entity);
    }
    @Override
    public Transportation update(Transportation entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Transportation entity) {repository.delete(entity);}

    public List<Transportation> findAll() {
        List<Transportation> allTransportations = new ArrayList<Transportation>();

        Iterable<Transportation> transportations = repository.findAll();
        for(Transportation transportation: transportations)
        {
            allTransportations.add(transportation);
        }
        return allTransportations;
    }
}
