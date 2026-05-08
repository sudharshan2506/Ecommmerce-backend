package com.platformforge.auth_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
    @NotBlank
    @Email
    String email,

    @Size (max = 8)
    @NotBlank
    String password,

    String role
)
{}
