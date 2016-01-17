package za.ac.cput.project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.PaymentMethod;
import za.ac.cput.project.repository.PaymentMethodRepository;
import za.ac.cput.project.services.PaymentMethodService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    PaymentMethodRepository repository;

    public List<PaymentMethod> getCard()
    {
        List<PaymentMethod> paymentMethodcard = new ArrayList<PaymentMethod>();

        Iterable<PaymentMethod> paymentMethods = repository.findAll();
        for(PaymentMethod paymentMethod: paymentMethods)
        {
            if(paymentMethod.getPaymentType().equals("card"))
                paymentMethodcard.add(paymentMethod);
        }

        return paymentMethodcard;
    }

    public List<PaymentMethod> getCash()
    {
        List<PaymentMethod> paymentMethodCash = new ArrayList<PaymentMethod>();

        Iterable<PaymentMethod> paymentMethods = repository.findAll();
        for(PaymentMethod paymentMethod: paymentMethods)
        {
            if(paymentMethod.getPaymentType().equals("local"))
                paymentMethodCash.add(paymentMethod);
        }

        return paymentMethodCash;
    }
}
