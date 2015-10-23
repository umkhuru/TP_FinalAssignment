package za.ac.cput.project.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/10/23.
 */
@Embeddable
public class ContactDetails implements Serializable{

    private String address;
    private String email;
    private Long cellNumber;
    private Long telNumber;

    public ContactDetails(){}

    public String getAddress() {
        return address;
    }
    public Long getCellNumber() {
        return cellNumber;
    }
    public String getEmail() {
        return email;
    }
    public Long getTelNumber() {
        return telNumber;
    }
    public ContactDetails(Builder builder){
        address=builder.address;
        email=builder.email;
        cellNumber=builder.cellNumber;
        telNumber=builder.telNumber;
    }

    public static class Builder{

        private String address;
        private String email;
        private Long cellNumber;
        private Long telNumber;

        public Builder(String email) {
            this.email = email;
        }
        public Builder address(String value){
            this.address=value;
            return this;
        }
        public Builder cellNumber(Long value){
            this.cellNumber=value;
            return this;
        }
        public Builder telNumber(Long value){
            this.telNumber=value;
            return this;
        }
        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDetails)) return false;

        ContactDetails that = (ContactDetails) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (cellNumber != null ? !cellNumber.equals(that.cellNumber) : that.cellNumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telNumber != null ? !telNumber.equals(that.telNumber) : that.telNumber != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (cellNumber != null ? cellNumber.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "ContactDetails{" +
                "address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cellNumber=" + cellNumber +
                ", telNumber=" + telNumber +
                '}';
    }
}
