package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/23.
 */
@Entity
public class PaymentMethod implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentmethodId;
    private String paymenttype;
    private float price;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="rentalId")
    private List<Rental> rentals = new ArrayList<Rental>();

    public PaymentMethod(){}

    public PaymentMethod(Builder builder){
        paymentmethodId=builder.paymentmethodId;
        paymenttype=builder.paymenttype;
        price=builder.price;
        rentals=builder.rentals;
    }

    public Long getPaymentmethodId() {
        return paymentmethodId;
    }

    public String getPaymentType() {
        return paymenttype;
    }

    public float getPrice() {
        return price;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public static class Builder{

        private Long paymentmethodId;
        private String paymenttype;
        private float price;
        private List<Rental> rentals = new ArrayList<Rental>();

        public Builder paymentmethodId(Long paymentmethodId){
            this.paymentmethodId=paymentmethodId;
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

        public Builder copy(PaymentMethod value){

            this.paymentmethodId=value.getPaymentmethodId();
            this.paymenttype=value.getPaymentType();
            this.price=value.getPrice();
            this.rentals=value.getRentals();
            return this;
        }

        public PaymentMethod build(){return new PaymentMethod(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod)) return false;

        PaymentMethod that = (PaymentMethod) o;

        if (Float.compare(that.price, price) != 0) return false;
        if (paymentmethodId != null ? !paymentmethodId.equals(that.paymentmethodId) : that.paymentmethodId != null)
            return false;
        if (paymenttype != null ? !paymenttype.equals(that.paymenttype) : that.paymenttype != null) return false;
        if (rentals != null ? !rentals.equals(that.rentals) : that.rentals != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentmethodId != null ? paymentmethodId.hashCode() : 0;
        result = 31 * result + (paymenttype != null ? paymenttype.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (rentals != null ? rentals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentmethodId=" + paymentmethodId +
                ", paymenttype='" + paymenttype + '\'' +
                ", price=" + price +
                ", rentals=" + rentals +
                '}';
    }
}
