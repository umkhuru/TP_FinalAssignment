package za.ac.cput.project.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Transportation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/10/29.
 */
public class RentalResource extends ResourceSupport {

    private Long resrentalId;
    private Date pickUpDate;
    private Date returnDate;
    private Float rate;
    private List<Client> clients = new ArrayList<Client>();
    private List<Transportation> transportations = new ArrayList<Transportation>();

    //constructor
    private RentalResource(){}


    public RentalResource(Builder builder){
        this.resrentalId=builder.resrentalId;
        this.pickUpDate=builder.pickUpDate;
        this.returnDate=builder.returnDate;
        this.rate=builder.rate;
        this.clients=builder.clients;
        this.transportations=builder.transportations;
    }

    public Long getResrentalId() {
        return resrentalId;
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

    public static class Builder {
        private Long resrentalId;
        private Date pickUpDate;
        private Date returnDate;
        private float rate;
        private List<Client> clients = new ArrayList<Client>();
        private List<Transportation> transportations = new ArrayList<Transportation>();

        public Builder(Date pickUpDate) {
            this.pickUpDate = pickUpDate;
        }

        public Builder resrentalId(Long value) {
            this.resrentalId = value;
            return this;
        }

        public Builder returnDate(Date value) {
            this.returnDate = value;
            return this;
        }

        public Builder rate(float value) {
            this.rate = value;
            return this;
        }

        public Builder clients(List<Client> value) {
            this.clients = value;
            return this;
        }

        public Builder transportations(List<Transportation> value) {
            this.transportations = value;
            return this;
        }

        public Builder copy(RentalResource value) {

            this.resrentalId = value.resrentalId;
            this.pickUpDate = value.pickUpDate;
            this.returnDate = value.returnDate;
            this.rate = value.rate;
            this.clients = value.clients;
            this.transportations = value.transportations;
            return this;
        }

        public RentalResource build() {
            return new RentalResource(this);
        }

        @Override
        public String toString() {
            return "RentalResource{" +
                    "resrentalId=" + resrentalId +
                    ", pickUpDate=" + pickUpDate +
                    ", returnDate=" + returnDate +
                    ", rate=" + rate +
                    ", clients=" + clients +
                    ", transportations=" + transportations +
                    '}';
        }
    }
    }
