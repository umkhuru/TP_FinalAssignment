package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Rental;
import za.ac.cput.project.repository.ClientRepository;
import za.ac.cput.project.services.ClientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository repository;
    public List<Client> getClient() {
        List<Client> allClients = new ArrayList<Client>();

        Iterable<Client> clients = repository.findAll();
        for(Client client: clients)
        {
            allClients.add(client);
        }

        return allClients;
    }


}
