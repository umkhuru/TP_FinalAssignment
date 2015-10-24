package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@Entity
public class Transportation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tansportationId;
    private String tansportationSerialNumber;
    private String tansportationMake;
    private String tansportationModel;
    private String tansportationType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="rentalId")
    private List<Rental> rentals = new ArrayList<Rental>();

    public Transportation(){}

    public Transportation(Builder builder){
        tansportationId=builder.tansportationId;
        tansportationSerialNumber=builder.tansportationSerialNumber;
        tansportationMake=builder.tansportationMake;
        tansportationMake=builder.tansportationMake;
        tansportationModel=builder.tansportationModel;
        tansportationType=builder.tansportationType;
        rentals=builder.rentals;
    }

    public Long getTansportationId() {
        return tansportationId;
    }

    public String getTansportationSerialNumber() {
        return tansportationSerialNumber;
    }

    public String getTansportationMake() {
        return tansportationMake;
    }

    public String getTansportationModel() {
        return tansportationModel;
    }

    public String getTansportationType() {
        return tansportationType;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public static class Builder{

        private Long tansportationId;
        private String tansportationSerialNumber;
        private String tansportationMake;
        private String tansportationModel;
        private String tansportationType;
        private List<Rental> rentals = new ArrayList<Rental>();

        public Builder tansportationId (Long tansportationId){
            this.tansportationId=tansportationId;
            return this;
        }

        public Builder(String value){
            this.tansportationSerialNumber=value;

        }

        public Builder tansportationMake(String value){
            this.tansportationMake=value;
            return this;
        }

        public Builder tansportationModel(String value){
            this.tansportationModel=value;
            return this;
        }

        public Builder tansportationType(String value){
            this.tansportationType=value;
            return this;
        }
        public Builder rentals(List<Rental> value){
            this.rentals=value;
            return this;
        }

        public Builder copy(Transportation value){

            this.tansportationId=value.getTansportationId();
            this.tansportationSerialNumber=value.getTansportationSerialNumber();
            this.tansportationMake=value.getTansportationMake();
            this.tansportationModel=value.getTansportationModel();
            this.tansportationType=value.getTansportationType();
            this.rentals=value.getRentals();
            return this;
        }

        public Transportation build(){return new Transportation(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportation)) return false;

        Transportation that = (Transportation) o;

        if (rentals != null ? !rentals.equals(that.rentals) : that.rentals != null) return false;
        if (tansportationId != null ? !tansportationId.equals(that.tansportationId) : that.tansportationId != null)
            return false;
        if (tansportationMake != null ? !tansportationMake.equals(that.tansportationMake) : that.tansportationMake != null)
            return false;
        if (tansportationModel != null ? !tansportationModel.equals(that.tansportationModel) : that.tansportationModel != null)
            return false;
        if (tansportationSerialNumber != null ? !tansportationSerialNumber.equals(that.tansportationSerialNumber) : that.tansportationSerialNumber != null)
            return false;
        if (tansportationType != null ? !tansportationType.equals(that.tansportationType) : that.tansportationType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tansportationId != null ? tansportationId.hashCode() : 0;
        result = 31 * result + (tansportationSerialNumber != null ? tansportationSerialNumber.hashCode() : 0);
        result = 31 * result + (tansportationMake != null ? tansportationMake.hashCode() : 0);
        result = 31 * result + (tansportationModel != null ? tansportationModel.hashCode() : 0);
        result = 31 * result + (tansportationType != null ? tansportationType.hashCode() : 0);
        result = 31 * result + (rentals != null ? rentals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "tansportationId=" + tansportationId +
                ", tansportationSerialNumber='" + tansportationSerialNumber + '\'' +
                ", tansportationMake='" + tansportationMake + '\'' +
                ", tansportationModel='" + tansportationModel + '\'' +
                ", tansportationType='" + tansportationType + '\'' +
                ", rentals=" + rentals +
                '}';
    }
}
