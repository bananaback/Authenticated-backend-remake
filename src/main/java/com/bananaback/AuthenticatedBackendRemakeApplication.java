package com.bananaback;

import com.bananaback.models.ApplicationUser;
import com.bananaback.models.Role;
import com.bananaback.repositories.RoleRepository;
import com.bananaback.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticatedBackendRemakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatedBackendRemakeApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findRoleByAuthority("ADMIN").isPresent()) {
				System.out.println("Heeeeyyyy");
				return;
			}
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roles);
			userRepository.save(admin);
		};
	}
}
