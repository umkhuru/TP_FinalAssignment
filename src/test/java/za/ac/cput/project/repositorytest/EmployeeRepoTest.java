package za.ac.cput.project.repositorytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.EmployeeFactory;
import za.ac.cput.project.domain.Employee;
import za.ac.cput.project.repository.EmployeeRepository;

/**
 * Created by student on 2015/11/02.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private EmployeeRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
    }
    @Test
    public void create() throws Exception{
        Employee employee = EmployeeFactory.createEmployee("Leonard","Botha","krismisroos slot 7","0448710716");
        repository.save(employee);
        id=employee.getEmployeeId();
        Assert.assertNotNull(employee);

    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Employee employee = repository.findOne(id);
        Assert.assertNotNull(employee);

    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Employee employee = repository.findOne(id);

        Employee newEmployee = new Employee
                .Builder(employee.getName())
                .copy(employee)
                .surname("Banzai")
                .build();

        repository.save(newEmployee);

        Employee updatedEmployee = repository.findOne(id);
        Assert.assertEquals(updatedEmployee.getSurname(),"Banzai");

    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{

        Employee employee = repository.findOne(id);
        repository.delete(employee);
        Employee deletedEmployee = repository.findOne(id);
        Assert.assertNull(deletedEmployee);
    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
