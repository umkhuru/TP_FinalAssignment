package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@Entity
public class Employee implements  Person, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String name;
    private String surname;
    private String employeeAddress;
    private String employeeContactDetails;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="clientId")
    private List<Client> clients = new ArrayList<Client>();

    public Employee(){}


    public Employee(Builder builder) {
        employeeId=builder.employeeId;
        name=builder.name;
        surname=builder.surname;
        employeeAddress=builder.employeeAddress;
        employeeContactDetails=builder.employeeContactDetails;
        clients=builder.clients;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getEmployeeContactDetails() {
        return employeeContactDetails;
    }

    public List<Client> getClients() {
        return clients;
    }

    public static class Builder{

        private Long employeeId;
        private String name;
        private String surname;
        private String employeeAddress;
        private String employeeContactDetails;
        private List<Client> clients = new ArrayList<Client>();


        public Builder employeeId(Long employeeId){
            this.employeeId=employeeId;
            return this;
        }

        public Builder(String value){
            this.name=value;

        }

        public Builder surname(String value){
            this.surname=value;
            return this;
        }

        public Builder employeeAddress(String value){
            this.employeeAddress=value;
            return this;
        }

        public Builder employeeContactDetails(String value){
            this.employeeContactDetails=value;
            return this;
        }

        public Builder clients(List<Client> value){
            this.clients=value;
            return this;
        }

        public Builder copy(Employee value){

            this.employeeId=value.getEmployeeId();
            this.name=value.getName();
            this.surname=value.getSurname();
            this.employeeAddress=value.getEmployeeAddress();
            this.employeeContactDetails=value.getEmployeeContactDetails();
            this.clients=value.getClients();

            return this;
        }

        public Employee build(){return new Employee(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (clients != null ? !clients.equals(employee.clients) : employee.clients != null) return false;
        if (employeeAddress != null ? !employeeAddress.equals(employee.employeeAddress) : employee.employeeAddress != null)
            return false;
        if (employeeContactDetails != null ? !employeeContactDetails.equals(employee.employeeContactDetails) : employee.employeeContactDetails != null)
            return false;
        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (employeeAddress != null ? employeeAddress.hashCode() : 0);
        result = 31 * result + (employeeContactDetails != null ? employeeContactDetails.hashCode() : 0);
        result = 31 * result + (clients != null ? clients.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeContactDetails='" + employeeContactDetails + '\'' +
                ", clients=" + clients +
                '}';
    }
}
