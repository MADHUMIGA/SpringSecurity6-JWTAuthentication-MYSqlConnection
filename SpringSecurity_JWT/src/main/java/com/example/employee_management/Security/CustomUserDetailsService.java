package com.example.employee_management.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.employee_management.model.Register;
import com.example.employee_management.repository.RegisterRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    	
    @Autowired
    private RegisterRepo registerRepo;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Register> userInfoOptional = registerRepo.findByEmail(username);
        if (!userInfoOptional.isPresent()) {
			throw new UsernameNotFoundException("Username: " + username + " not found");
        } 
		Register userInfo = userInfoOptional.get();
		return User.builder()
				.username(userInfo.getEmail())
				.password(userInfo.getPassword())
				.roles(userInfo.getRole())
				.build();
		
        }
           
}
