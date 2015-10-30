package za.ac.cput.project.domaintest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.EmployeeFactory;
import za.ac.cput.project.domain.Employee;

/**
 * Created by student on 2015/10/25.
 */
public class EmployeeTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testEmployee() throws Exception {

        Employee employee = EmployeeFactory.createEmployee("Teddy","Long","joStreet","123456789");

        Assert.assertEquals("Teddy",employee.getName());

    }

    @After
    public void tearDown() throws Exception {




    }
}
