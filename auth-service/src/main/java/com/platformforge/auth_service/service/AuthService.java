package com.platformforge.auth_service.service;

import com.platformforge.auth_service.config.SecurityBeansConfig;
import com.platformforge.auth_service.exception.DuplicateEmailException;
import com.platformforge.auth_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final SecurityBeansConfig securityBeansConfig;

    public void registerUser(
            String email,
            String password,
            String role
    ) {

        if (userRepository.existsByEmail(email)) {

            throw new DuplicateEmailException(
                    "Email ID already exists"
            );
        }

        String hashedPassword =
                securityBeansConfig
                        .passwordEncoder()
                        .encode(password);

        userRepository.createUser(
                email,
                hashedPassword,
                role
        );
    }
}