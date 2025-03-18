package com.phiworks.security.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Log4j2
public class CustomUserDetailsServiceTests {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void loadUserByUsernameTest() {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername("admin@test.com");
        log.info(userDetails.toString());
    }

    @Test
    public void passwordMatchTest() {
        String rawPassword = "admin123";
        String encodedPassword = "$2a$10$b5PL/WteLdAzfYyta9.kH.2mcgOI13.g1whVh3H1IvZ0jBtFN.d2K";

        boolean result = passwordEncoder.matches(rawPassword, encodedPassword);
        log.info("result : {}", result);
    }
}
