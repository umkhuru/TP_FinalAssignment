package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/23.
 */
@Entity
public class Client implements Person, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String name;
    private String surname;
    @Embedded
    private ContactDetails contactDetails;
    @Embedded
    private Login login;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="clientId")
    private List<Employee> employees = new ArrayList<Employee>();

    private Client(){};

    public Client(Builder builder){
        clientId=builder.clientId;
        name=builder.name;
        surname=builder.surname;
        contactDetails=builder.contactDetails;
        login=builder.login;
        employees=builder.employees;
    }
    public Long getClientId() {
        return clientId;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    public ContactDetails getContactDetails() {
        return contactDetails;
    }
    public Login getLogin() {
        return login;
    }
    public List<Employee> getEmployee() {
        return employees;
    }


    public static class Builder{

        private Long clientId;
        private String name;
        private String surname;
        private ContactDetails contactDetails;
        private Login login;
        private List<Employee> employees = new ArrayList<Employee>();

        public Builder(String name){
            this.name=name;
        }

        public Builder clientId(Long value){
            this.clientId=value;
            return this;
        }

        public Builder surname(String value){
            this.surname=value;
            return this;
        }

        public Builder contactDetails(ContactDetails value){
            this.contactDetails=value;
            return this;
        }

        public Builder login(Login value){
            this.login=value;
            return this;
        }
        public Builder employees(List<Employee> value){
            this.employees=value;
            return this;
        }

        public Builder copy(Client value){

            this.clientId=value.getClientId();
            this.name=value.getName();
            this.surname=value.getSurname();
            this.contactDetails=value.getContactDetails();
            this.login=value.getLogin();
            this.employees=value.getEmployee();
            return this;
        }

        public Client build(){return new Client(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (clientId != null ? !clientId.equals(client.clientId) : client.clientId != null) return false;
        if (contactDetails != null ? !contactDetails.equals(client.contactDetails) : client.contactDetails != null)
            return false;
        if (employees != null ? !employees.equals(client.employees) : client.employees != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (contactDetails != null ? contactDetails.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contactDetails=" + contactDetails +
                ", login=" + login +
                ", employees=" + employees +
                '}';
    }
}
