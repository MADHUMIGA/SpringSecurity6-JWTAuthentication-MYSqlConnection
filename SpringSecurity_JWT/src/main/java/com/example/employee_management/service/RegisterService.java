package com.example.employee_management.service;

import org.springframework.stereotype.Service;


import com.example.employee_management.model.Register;
import com.example.employee_management.repository.RegisterRepo;

@Service
public class RegisterService {
     private RegisterRepo registerRepo;

    public RegisterService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }

     // post
    public Register saveRegister(Register register) {
        try {
            return registerRepo.save(register);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // public Register findByEmail(String email) {
    //     return registerRepo.findByEmail(email);
    // }
}
