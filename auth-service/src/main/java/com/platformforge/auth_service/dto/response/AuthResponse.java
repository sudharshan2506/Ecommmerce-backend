package com.platformforge.auth_service.dto.response;

public record AuthResponse(
        Long userId,
        String email,
        String token
) {
}
