package com.example.employee_management.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    
    @Id
    private Long empId;
    private String empName;
    private String dept;
    private String gmail;
    private String phno;
    private Date dob;
    private String gender;
    private int salary;
    private Date joinDate;



}
