package com.platformforge.auth_service.controller;

import com.platformforge.auth_service.dto.request.RegisterRequest;
import com.platformforge.auth_service.service.AuthService;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {

        authService.registerUser(
                request.email(),
                request.password(),
                request.role()
        );
        log.info("New user registration request");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        Map.of(
                                "message",
                                "User registered successfully"
                        )
                );
    }
}