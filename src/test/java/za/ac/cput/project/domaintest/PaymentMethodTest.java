package za.ac.cput.project.domaintest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.PaymentMethodFactory;
import za.ac.cput.project.domain.PaymentMethod;
import za.ac.cput.project.domain.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/26.
 */
public class PaymentMethodTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreatePaymentmethod() throws Exception {
        List<Rental> rentals = new ArrayList<Rental>();

        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Cash", 200L,rentals);

        Assert.assertEquals("Cash", paymentMethod.getPaymentType());


    }

    @After
    public void tearDown() throws Exception {


    }
}
