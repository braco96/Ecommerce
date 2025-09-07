package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }
}
