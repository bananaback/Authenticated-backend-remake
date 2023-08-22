package com.bananaback.services;

import com.bananaback.models.ApplicationUser;
import com.bananaback.models.Role;
import com.bananaback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Mock code
        System.out.println("In the user details service");
        return userRepository.findApplicationUserByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
    }
}
