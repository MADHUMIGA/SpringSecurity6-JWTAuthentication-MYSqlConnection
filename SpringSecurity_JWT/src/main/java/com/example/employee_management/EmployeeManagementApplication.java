package com.example.employee_management;

// import java.security.SecureRandom;
// import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {

		// for testing // pre-encoding
		// String password = "admin@123";
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // String hashedPassword = passwordEncoder.encode(password);
        // System.out.println("Hashed Password: " + hashedPassword);
		
        // Jwt secret key base64 
		// byte[] key = new byte[32]; // 256 bits
        // SecureRandom random = new SecureRandom();
        // random.nextBytes(key);
        // String base64Key = Base64.getEncoder().encodeToString(key);
        // System.out.println("key:"+base64Key);
		
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
