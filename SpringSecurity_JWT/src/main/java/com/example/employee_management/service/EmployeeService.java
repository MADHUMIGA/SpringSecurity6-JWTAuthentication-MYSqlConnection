package com.example.employee_management.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    

    // Method to save a single employee
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Method to save a list of employees
    public List<Employee> saveEmps(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }



    // retrive
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    // searchByName
    public List<Employee> getEmpByName(String empName) {
        return employeeRepository.findByempName(empName);
    }

    // updateDetails
    public Employee updateEmp(Long id, Employee employee) {
        return employeeRepository.save(employee);
    }

    // deleteDetailsById
    public void delEmpById(Long empId) {
        employeeRepository.deleteById(empId);

    }

    // pagination
    // public Page<Employee> paginationEmployee(int offset,int pagesize){
    // return employeeRepository.findAll(PageRequest.of(offset,pagesize));
    // }
    public Page<Employee> paginationEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

}
