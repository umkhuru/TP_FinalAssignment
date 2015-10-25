package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.PaymentMethod;
import za.ac.cput.project.domain.Rental;
import za.ac.cput.project.domain.Transportation;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/10/24.
 */
public class RentalFactory {

    public static Rental createRental(Map<Date, Date> value, float rate, List<Client> clients, List<Transportation> transportations)
    {
        Rental rental = new Rental
                .Builder(value.get("pickUpDate"))
                .returnDate(value.get("returnDate"))
                .rate(rate)
                .clients(clients)
                .transportations(transportations)
                .build();

        return rental;
    }
}
