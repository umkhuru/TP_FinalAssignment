package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/10/23.
 */
@Entity
public class Rental implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentalId;
    private Date pickUpDate;
    private Date returnDate;
    private Float rate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="rentalId")
    private List<Client> clients = new ArrayList<Client>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "rentalId")
    private List<Transportation> transportations = new ArrayList<Transportation>();

    public Rental(){}

    public Rental(Builder builder){
        rentalId=builder.rentalId;
        pickUpDate=builder.pickUpDate;
        returnDate=builder.returnDate;
        rate=builder.rate;
        clients=builder.clients;
        transportations=builder.transportations;
    }

    public Long getRentalId() {
        return rentalId;
    }
    public Date getPickUpDate() {
        return pickUpDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public Float getRate() {
        return rate;
    }
    public List<Client> getClients() {
        return clients;
    }
    public List<Transportation> getTransportations() {
        return transportations;
    }

    public static class Builder{
        private Long rentalId;
        private Date pickUpDate;
        private Date returnDate;
        private float rate;
        private List<Client> clients = new ArrayList<Client>();
        private List<Transportation> transportations = new ArrayList<Transportation>();

        public Builder(Date pickUpDate) {
            this.pickUpDate = pickUpDate;
        }
        public Builder rentalId(Long value){
            this.rentalId=value;
            return this;
        }
        public Builder returnDate(Date value){
            this.returnDate=value;
            return this;
        }
        public Builder rate(float value){
            this.rate=value;
            return this;
        }
        public Builder clients(List<Client> value){
            this.clients=value;
            return this;
        }
        public Builder transportations(List<Transportation> value){
            this.transportations=value;
            return this;
        }

        public Builder copy(Rental value){

            this.rentalId=value.getRentalId();
            this.pickUpDate=value.getPickUpDate();
            this.returnDate=value.getReturnDate();
            this.rate=value.getRate();
            this.clients=value.getClients();
            this.transportations=value.getTransportations();
            return this;
        }

        public Rental build(){
            return new Rental(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;

        Rental rental = (Rental) o;

        if (clients != null ? !clients.equals(rental.clients) : rental.clients != null) return false;
        if (pickUpDate != null ? !pickUpDate.equals(rental.pickUpDate) : rental.pickUpDate != null) return false;
        if (rate != null ? !rate.equals(rental.rate) : rental.rate != null) return false;
        if (rentalId != null ? !rentalId.equals(rental.rentalId) : rental.rentalId != null) return false;
        if (returnDate != null ? !returnDate.equals(rental.returnDate) : rental.returnDate != null) return false;
        if (transportations != null ? !transportations.equals(rental.transportations) : rental.transportations != null)
            return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = rentalId != null ? rentalId.hashCode() : 0;
        result = 31 * result + (pickUpDate != null ? pickUpDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (clients != null ? clients.hashCode() : 0);
        result = 31 * result + (transportations != null ? transportations.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", pickUpDate=" + pickUpDate +
                ", returnDate=" + returnDate +
                ", rate=" + rate +
                ", clients=" + clients +
                ", transportations=" + transportations +
                '}';
    }
}
