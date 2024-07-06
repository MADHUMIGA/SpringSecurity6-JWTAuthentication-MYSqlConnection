package com.example.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.transaction.annotation.Transactional;

import com.example.employee_management.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
    
     @Query("SELECT e FROM Employee e WHERE e.empName = ?1")
    List<Employee> findByempName(String empName);
    

    // @Transactional
    // @Modifying
    // @Query("DELETE FROM Employee e WHERE e.empName = ?1")
    // void delByempName(String empName);
}
