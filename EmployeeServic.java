package org.Amansoni.Employeemanagementproject;

import java.util.List;

public interface EmployeeServic {

    String createEmployee(Employee employee);

    List<Employee> readEmployees();

//    int
    boolean deleteEmployee(long id);

    String updateEmployee(Long id, Employee employee);

    Employee readEmployees(long id);
}
