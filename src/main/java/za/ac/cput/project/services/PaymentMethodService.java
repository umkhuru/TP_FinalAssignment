package za.ac.cput.project.services;

import za.ac.cput.project.domain.PaymentMethod;

import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
public interface PaymentMethodService {

    public List<PaymentMethod> getCard();
    public List<PaymentMethod> getCash();
}
