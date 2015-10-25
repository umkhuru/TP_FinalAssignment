package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Transportation;
import za.ac.cput.project.repository.TransportationRepository;
import za.ac.cput.project.services.CarListService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@Service
public class CarListServiceImpl implements CarListService{

    @Autowired
    TransportationRepository repository;


    public List<Transportation> getLocal()
    {
        List<Transportation> transportationsLocal = new ArrayList<Transportation>();

        Iterable<Transportation> transportations = repository.findAll();
        for(Transportation transportation: transportations)
        {
            if(transportation.getTansportationType().equals("local"))
            transportationsLocal.add(transportation);
        }

        return transportationsLocal;
    }


    public List<Transportation> getLuxery()
    {
        List<Transportation> transportationsLuxery = new ArrayList<Transportation>();

        Iterable<Transportation> transportations = repository.findAll();
        for(Transportation transportation: transportations)
        {
            if(transportation.getTansportationType().equals("luxery"))
                transportationsLuxery.add(transportation);
        }

        return transportationsLuxery;
    }


    public List<Transportation> getExotic()
    {
        List<Transportation> transportationsExotic = new ArrayList<Transportation>();

        Iterable<Transportation> transportations = repository.findAll();
        for(Transportation transportation: transportations)
        {
            if(transportation.getTansportationType().equals("exotic"))
                transportationsExotic.add(transportation);
        }

        return transportationsExotic;
    }
}
