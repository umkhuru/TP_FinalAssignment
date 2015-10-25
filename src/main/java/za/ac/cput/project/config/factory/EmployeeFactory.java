package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Employee;

import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
public class EmployeeFactory {

    public static Employee createEmployee(String name,String surname,String employeeAddress,String employeeContactDetails)
    {
        Employee employee = new Employee
                .Builder(name)
                .surname(surname)
                .employeeAddress(employeeAddress)
                .employeeContactDetails(employeeContactDetails)
                .build();

        return employee;
    }
}
