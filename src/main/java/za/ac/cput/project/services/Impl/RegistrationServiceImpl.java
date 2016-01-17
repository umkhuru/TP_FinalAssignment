package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.repository.ClientRepository;
import za.ac.cput.project.services.RegistrationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/11/02.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    ClientRepository repository;

    public List<Client> getRegister()
    {
        List<Client> clients = new ArrayList<Client>();

        return clients;
    }
}
