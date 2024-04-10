package org.Amansoni.Employeemanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RestController
public class EmployeeController {

    EmployeeServic employeeServic = new EmployeeServicImpl();

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeServic.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeServic.readEmployees(id);
    }

    @PostMapping("employees")
    public String createEmployees(@RequestBody Employee employee){
        return employeeServic.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable long id){
        if (employeeServic.deleteEmployee(id))
         return "Delete Successfully";
        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee){
        return employeeServic.updateEmployee(id, employee);
    }
}