package com.example.employee_management.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.model.Register;
import com.example.employee_management.service.RegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class RegisterController {
     private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

     private RegisterService registerService;
    public RegisterController(RegisterService registerService) {
       
        this.registerService = registerService;
       
    }
     @Autowired
    private PasswordEncoder passwordEncoder;

     // Registration endpoint
     @PostMapping("/registration")
     public ResponseEntity<?> newRegister(@RequestBody Register register) {
        try{
        if (register.getRole() == null) {
            register.setRole("USER");
        }
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        Register reg = registerService.saveRegister(register);
        return new ResponseEntity<>(reg, HttpStatus.CREATED);
        }
        catch (Exception e) {
             logger.error("Error registering user: ", e);
             return new ResponseEntity<>("Error registering user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
 
   
}
