package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.PaymentMethod;
import za.ac.cput.project.domain.Rental;

import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
public class PaymentMethodFactory {

    public static PaymentMethod createPaymentMethod(String paymentype,float price,List<Rental> rentals)
    {
        PaymentMethod paymentMethod = new PaymentMethod
                .Builder(paymentype)
                .price(price)
                .rentals(rentals)
                .build();

        return paymentMethod;
    }
}
