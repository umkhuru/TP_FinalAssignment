package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/10/24.
 */
public class ClientFactory {

    public static Client createClient(Map<String, String> value, Login login, ContactDetails contactDetails, List<Employee> employees)
    {
        Client client = new Client
                .Builder(value.get("name"))
                .surname(value.get("surname"))
                .login(login)
                .contactDetails(contactDetails)
                .employees(employees)
                .build();

        return client;
    }
}
