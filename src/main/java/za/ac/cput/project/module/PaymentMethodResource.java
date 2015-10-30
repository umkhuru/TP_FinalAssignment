package za.ac.cput.project.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.project.domain.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/29.
 */
public class PaymentMethodResource extends ResourceSupport {

    private Long respaymentmethodId;
    private String paymenttype;
    private float price;
    private List<Rental> rentals = new ArrayList<Rental>();

    private PaymentMethodResource(){}

    public PaymentMethodResource(Builder builder){
        this.respaymentmethodId=builder.respaymentmethodId;
        this.paymenttype=builder.paymenttype;
        this.price=builder.price;
        this.rentals=builder.rentals;
    }

    public Long getRespaymentmethodId() {
        return respaymentmethodId;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public float getPrice() {
        return price;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public static class Builder{

        private Long respaymentmethodId;
        private String paymenttype;
        private float price;
        private List<Rental> rentals = new ArrayList<Rental>();

        public Builder respaymentmethodId(Long respaymentmethodId){
            this.respaymentmethodId=respaymentmethodId;
            return this;
        }

        public Builder(String value){
            this.paymenttype=value;

        }

        public Builder price(float value){
            this.price=value;
            return this;
        }

        public Builder rentals(List<Rental> value){
            this.rentals=value;
            return this;
        }

        public Builder copy(PaymentMethodResource value){

            this.respaymentmethodId=value.respaymentmethodId;
            this.paymenttype=value.paymenttype;
            this.price=value.price;
            this.rentals=value.rentals;
            return this;
        }

        public PaymentMethodResource build(){return new PaymentMethodResource(this);}
    }

    @Override
    public String toString() {
        return "PaymentMethodResource{" +
                "respaymentmethodId=" + respaymentmethodId +
                ", paymenttype='" + paymenttype + '\'' +
                ", price=" + price +
                ", rentals=" + rentals +
                '}';
    }
}
