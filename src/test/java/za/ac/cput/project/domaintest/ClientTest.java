package za.ac.cput.project.domaintest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.ClientFactory;
import za.ac.cput.project.config.factory.ContactDetailsFactory;
import za.ac.cput.project.config.factory.LoginFactory;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.ContactDetails;
import za.ac.cput.project.domain.Employee;
import za.ac.cput.project.domain.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/10/25.
 */

public class ClientTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testClient() throws Exception {

        List<Employee> employees = new ArrayList<Employee>();


        Map<String, String> svalues = new HashMap<String, String>();

        svalues.put("name","jimmy");
        svalues.put("surname","Jackson");

        Login logins = LoginFactory.createLogin("qweqwe","qweqwe");

        Map<String, String> values = new HashMap<String, String>();
        values.put("address","mmmmmmwmmwmwmwmwm");
        values.put("email","asasadasd@gmail.com");

        ContactDetails contactDetails = ContactDetailsFactory.createContactDetails(values, 1234L,5678L);

        Client client = ClientFactory.createClient(svalues, logins, contactDetails, employees);

        Assert.assertEquals("jimmy","jimmy");
    }

    @After
    public void tearUpdateClient() throws Exception {




    }
}
