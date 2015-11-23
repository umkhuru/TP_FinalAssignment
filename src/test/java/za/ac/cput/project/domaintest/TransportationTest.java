package za.ac.cput.project.domaintest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.TransportationFactory;
import za.ac.cput.project.domain.Transportation;

/**
 * Created by student on 2015/10/26.
 */
public class TransportationTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateTransportation() throws Exception {

        Transportation transportation = TransportationFactory.createTransportation("12345", "BMW", "2009", "luxsery");

        Assert.assertEquals("BMW",transportation.getTansportationMake());


    }

    @After
    public void tearDown() throws Exception {




    }
}
