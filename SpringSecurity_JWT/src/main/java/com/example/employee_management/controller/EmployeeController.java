package com.example.employee_management.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class EmployeeController {
    
    private EmployeeService employeeService;
    
    public EmployeeController( EmployeeService employeeService) {
       
        this.employeeService = employeeService;
       
    }
   
 

    @PostMapping("/addemp")
    public ResponseEntity<Void> addEmp(@RequestBody Employee employee) {
        Employee emp = employeeService.saveEmp(employee);
        if (emp != null) {
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(500).build();
    }

    @PostMapping("/admin/addemps")
    public ResponseEntity<Void> addEmps(@RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = employeeService.saveEmps(employees);
        if (savedEmployees != null && !savedEmployees.isEmpty()) {
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(500).build();
    }


    // @PreAuthorize("hasRole('ADMIN')")
     @GetMapping("/admin/emplist")
    public List<Employee> empList() {
        return employeeService.getAllEmp();
    }

    @GetMapping("/admin/search/{empName}")
    public List<Employee> searchEmp(@PathVariable String empName) {
        return employeeService.getEmpByName(empName);
    }

     @PutMapping("/admin/editemp/{id}")
    public Employee editEmp(@PathVariable Long id, @RequestBody Employee employee) {
       return employeeService.updateEmp(id,employee); 
     }

     @DeleteMapping("/admin/delete/{empId}")
        public void delEmp(@PathVariable Long empId){
             employeeService.delEmpById(empId);
        }

   
    @GetMapping("/admin/emplist/{page}/{size}")
    public ResponseEntity<Page<Employee>> getPaginationEmployee(
            @PathVariable("page") int page, 
            @PathVariable("size") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeService.paginationEmployee(pageable);
        if (employeePage != null && !employeePage.isEmpty()) {
            return new ResponseEntity<>(employeePage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
