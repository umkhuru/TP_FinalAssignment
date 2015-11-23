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
import za.ac.cput.project.config.factory.TransportationFactory;
import za.ac.cput.project.domain.Transportation;
import za.ac.cput.project.repository.TransportationRepository;

/**
 * Created by student on 2015/11/02.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TransportationRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private TransportationRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }
    @Test
    public void create() throws Exception{

        Transportation transportation = TransportationFactory.createTransportation("golf1234567890","Golf","GTI 1.8l","local");
        repository.save(transportation);
        id=transportation.getTansportationId();
        Assert.assertNotNull(transportation);


    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Transportation transportation = repository.findOne(id);
        Assert.assertNotNull(transportation);


    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Transportation transportation = repository.findOne(id);

        Transportation newTransportation = new Transportation
                .Builder(transportation.getTansportationSerialNumber())
                .copy(transportation)
                .tansportationModel("Gti 2.0l")
                .build();

        repository.save(newTransportation);

        Transportation updatedTransportation = repository.findOne(id);
        Assert.assertEquals(updatedTransportation.getTansportationModel(),"Gti 2.0l");

    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{

        Transportation transportation = repository.findOne(id);
        repository.delete(transportation);
        Transportation deletedTransportation = repository.findOne(id);
        Assert.assertNull(deletedTransportation);
    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
