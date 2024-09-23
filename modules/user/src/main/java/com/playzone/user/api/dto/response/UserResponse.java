package com.playzone.user.api.dto.response;

import jakarta.validation.constraints.NotEmpty;

public record UserResponse(
    @NotEmpty String email,
    String firstName,
    String lastName
) {
}
