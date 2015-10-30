package za.ac.cput.project.domaintest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.LoginFactory;
import za.ac.cput.project.domain.Login;
import za.ac.cput.project.domain.Transportation;

/**
 * Created by student on 2015/10/26.
 */
public class LoginTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateLogin() throws Exception {

        Login login = LoginFactory.createLogin("Teddy", "Long");

        Assert.assertEquals("Long", login.getPassword());



    }

    @After
    public void tearDown() throws Exception {


    }
}
