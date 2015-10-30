package za.ac.cput.project.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.project.domain.Person;

/**
 * Created by student on 2015/10/29.
 */
public class EmployeeResource extends ResourceSupport implements Person{

    private Long resemployeeId;
    private String name;
    private String surname;
    private String employeeAddress;
    private String employeeContactDetails;

    private EmployeeResource(){}

    public EmployeeResource(Builder builder) {
        resemployeeId=builder.resemployeeId;
        name=builder.name;
        surname=builder.surname;
        employeeAddress=builder.employeeAddress;
        employeeContactDetails=builder.employeeContactDetails;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }

    public Long getResemployeeId() {
        return resemployeeId;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getEmployeeContactDetails() {
        return employeeContactDetails;
    }

    public static class Builder{

        private Long resemployeeId;
        private String name;
        private String surname;
        private String employeeAddress;
        private String employeeContactDetails;


        public Builder resemployeeId(Long resemployeeId){
            this.resemployeeId=resemployeeId;
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


        public Builder copy(EmployeeResource value){

            this.resemployeeId=value.resemployeeId;
            this.name=value.name;
            this.surname=value.surname;
            this.employeeAddress=value.employeeAddress;
            this.employeeContactDetails=value.employeeContactDetails;

            return this;
        }

        public EmployeeResource build(){return new EmployeeResource(this);}

        @Override
        public String toString() {
            return "EmployeeResource{" +
                    "resemployeeId=" + resemployeeId +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", employeeAddress='" + employeeAddress + '\'' +
                    ", employeeContactDetails='" + employeeContactDetails + '\'' +
                    '}';
        }
        }
    }
