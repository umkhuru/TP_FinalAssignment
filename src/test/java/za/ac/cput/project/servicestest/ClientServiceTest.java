package za.ac.cput.project.servicestest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.ClientFactory;
import za.ac.cput.project.config.factory.ContactDetailsFactory;
import za.ac.cput.project.config.factory.EmployeeFactory;
import za.ac.cput.project.config.factory.LoginFactory;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.ContactDetails;
import za.ac.cput.project.domain.Employee;
import za.ac.cput.project.domain.Login;
import za.ac.cput.project.repository.ClientRepository;
import za.ac.cput.project.services.ClientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/11/22.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ClientServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ClientService service;
    @Autowired
    private ClientRepository repository;

    private Long id;
    private List<Employee> employees;

    @BeforeMethod
    public void setUp() throws Exception {
        employees = new ArrayList<Employee>();

    }
    @Test
    public void create() throws Exception{
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Mark");
        values.put("surname", "Doe");

        Login login = LoginFactory.createLogin("John","password101");

        Map<String,String> value = new HashMap<String,String>();
        value.put("address","rol straat 1");
        value.put("email", "johndoe@gmail.com");

        ContactDetails contactDetails = ContactDetailsFactory.createContactDetails(value,1234124L,21342124L);

        Employee employee = EmployeeFactory.createEmployee("Teddy", "Long", "joStreet", "123456789");

        employees.add(employee);

        Client client = ClientFactory.createClient(values,login,contactDetails,employees);
        repository.save(client);
        id=client.getClientId();
        Assert.assertNotNull(client);
        //Assert.assertEquals("John",values.get("surname"));

    }
    @Test(dependsOnMethods = "create")
    public void testGetClients() throws Exception {
        List<Client> clients = service.getClient();
        Assert.assertTrue(clients.size() == 2);

    }
}
