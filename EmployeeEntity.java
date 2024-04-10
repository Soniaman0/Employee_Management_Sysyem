package org.Amansoni.Employeemanagementproject;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String email;
}
