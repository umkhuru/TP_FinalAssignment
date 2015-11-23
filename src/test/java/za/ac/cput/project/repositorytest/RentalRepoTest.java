package za.ac.cput.project.repositorytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.*;
import za.ac.cput.project.domain.*;
import za.ac.cput.project.repository.RentalRepository;

import java.util.*;

/**
 * Created by student on 2015/11/02.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RentalRepoTest extends AbstractTestNGSpringContextTests{

    private Long id;

    private List<Client> clients;
    private List<Transportation> transportations;
    private List<Employee> employees;

    @Autowired
    private RentalRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        clients = new ArrayList<Client>();
        transportations = new ArrayList<Transportation>();
        employees = new ArrayList<Employee>();
    }
    @Test
    public void create() throws Exception{

        Date pickupDate = new Date(2015,10,12);
        Date returnDate = new Date(2015,10,15);
        Map<String,Date> valued = new HashMap<String,Date>();
        valued.put("pickUpDate",pickupDate);
        valued.put("returnDate", returnDate);

        Map<String,String> value = new HashMap<String,String>();
        value.put("name","John");
        value.put("surname", "Doe");

        Login login = LoginFactory.createLogin("John", "password101");

        Map<String,String> values = new HashMap<String,String>();
        values.put("address","rol straat 1");
        values.put("email", "johndoe@gmail.com");

        ContactDetails contactDetails = ContactDetailsFactory.createContactDetails(values, 1234124L, 21342124L);

        Employee employee = EmployeeFactory.createEmployee("Leonard","Botha","krismisroos slot 7","0448710716");

        employees.add(employee);

        Client client = ClientFactory.createClient(value,login,contactDetails,employees);
        clients.add(client);
//----------------------------------------------------------------------------------------------------------------------------------------
        Transportation transportation = TransportationFactory.createTransportation("golf1234567890","Golf","GTI 1.8l","local");
        transportations.add(transportation);

        Rental rental = RentalFactory.createRental(valued,1000, clients,transportations);
        repository.save(rental);
        id=rental.getRentalId();
        Assert.assertNotNull(rental);

    }
    //@Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Rental rental= repository.findOne(id);
        Assert.assertNotNull(rental);


    }
    //@Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Rental rental = repository.findOne(id);
        Date newReturnDate = new Date(2015,10,20);
        Rental newRental = new Rental
                .Builder(rental.getPickUpDate())
                .copy(rental)
                .returnDate(newReturnDate)
                .build();

        repository.save(newRental);

        Rental updatedRental = repository.findOne(id);
        Assert.assertEquals(updatedRental.getReturnDate(),newReturnDate);

    }
    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception{

        Rental rental = repository.findOne(id);
        repository.delete(rental);
        Rental deletedRental = repository.findOne(id);
        Assert.assertNull(deletedRental);
    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
