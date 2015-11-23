package za.ac.cput.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.module.ClientResource;
import za.ac.cput.project.services.ClientService;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 2015/10/24.
 */
@RestController
@RequestMapping(value = "/Client/**")
public class ClientHistoryPage {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "client", method = RequestMethod.GET)
    public String Index(){
        return "this is my client page";
    }

    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public List<ClientResource> getClients() {
        List<ClientResource> hateoas = new ArrayList<ClientResource>();
        List<Client> clients = service.getClient();
        for (Client client : clients) {
            ClientResource clientRes = new ClientResource
                    .Builder(client.getName())
                    .surname(client.getSurname())
                    .contactDetails(client.getContactDetails())
                    .login(client.getLogin())
                    .employees(client.getEmployee())
                    .build();
            Link clientss = new
                    Link("http://localhost:8080/clients/" + clientRes.getResclientId().toString())
                    .withRel("clients");
            clientRes.add(clientss);
            hateoas.add(clientRes);
        }
        return hateoas;
    }

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String error(){
        return "this page was not found";
    }
}