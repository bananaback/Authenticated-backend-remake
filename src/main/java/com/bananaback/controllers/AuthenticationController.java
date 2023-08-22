package com.bananaback.controllers;

import com.bananaback.models.ApplicationUser;
import com.bananaback.models.LoginResponseDTO;
import com.bananaback.models.RegistrationDTO;
import com.bananaback.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        System.out.println(body.getUsername() + body.getPassword());
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
