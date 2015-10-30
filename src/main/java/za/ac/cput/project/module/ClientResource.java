package za.ac.cput.project.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.project.domain.ContactDetails;
import za.ac.cput.project.domain.Employee;
import za.ac.cput.project.domain.Login;
import za.ac.cput.project.domain.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/29.
 */
public class ClientResource extends ResourceSupport implements Person {

    private Long resclientId;
    private String name;
    private String surname;
    private ContactDetails contactDetails;
    private Login login;
    private List<Employee> employees = new ArrayList<Employee>();

    private ClientResource(){}

    public ClientResource(Builder builder){
        this.resclientId=builder.resclientId;
        this.name=builder.name;
        this.surname=builder.surname;
        this.contactDetails=builder.contactDetails;
        this.login=builder.login;
        this.employees=builder.employees;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }

    public Long getResclientId() {
        return resclientId;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public Login getLogin() {
        return login;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public static class Builder{

        private Long resclientId;
        private String name;
        private String surname;
        private ContactDetails contactDetails;
        private Login login;
        private List<Employee> employees = new ArrayList<Employee>();

        public Builder(String name){
            this.name=name;
        }

        public Builder resclientId(Long value){
            this.resclientId=value;
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

        public Builder copy(ClientResource value){

            this.resclientId=value.resclientId;
            this.name=value.name;
            this.surname=value.surname;
            this.contactDetails=value.contactDetails;
            this.login=value.login;
            this.employees=value.employees;
            return this;
        }

        public ClientResource build(){return new ClientResource(this);}

        @Override
        public String toString() {
            return "ClientResource{" +
                    "resclientId=" + resclientId +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", contactDetails=" + contactDetails +
                    ", login=" + login +
                    ", employees=" + employees +
                    '}';
        }
        }
    }
