package com.example.employee_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.employee_management.model.Register;

public interface RegisterRepo  extends JpaRepository<Register,Long>{
    @Query(value = "select * from register where email = ?1", nativeQuery = true)
    // Register findByEmail(String email);
    Optional<Register> findByEmail(String email);
}
