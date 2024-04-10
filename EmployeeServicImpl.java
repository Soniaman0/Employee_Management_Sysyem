package org.Amansoni.Employeemanagementproject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServicImpl implements EmployeeServic {



    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public Employee readEmployees(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeList) {
         Employee emp = new Employee();
         emp.setId(employeeEntity.getId());
         emp.setName(employeeEntity.getName());
         emp.setPhone(employeeEntity.getPhone());
         emp.setEmail(employeeEntity.getEmail());
         employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity exestingEmployee = employeeRepository.findById(id).get();

        exestingEmployee.setName(employee.getName());
        exestingEmployee.setPhone(employee.getPhone());
        exestingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(exestingEmployee);
        return "Update succsfully";
    }

}
