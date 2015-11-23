package za.ac.cput.project.repositorytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import za.ac.cput.project.App;
import za.ac.cput.project.repository.PaymentMethodRepository;


/**
 * Created by student on 2015/11/02.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PaymentMethodRepoTest extends AbstractTestNGSpringContextTests{

    private Long id;
    @Autowired
    private PaymentMethodRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    public void create() throws Exception{}
    public void read() throws Exception{}
    public void update() throws Exception{}
    public void delete() throws Exception{}

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
