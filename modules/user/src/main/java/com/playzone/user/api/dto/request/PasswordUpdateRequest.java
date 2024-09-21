package com.playzone.user.api.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record PasswordUpdateRequest(
    @NotEmpty
    String password
) {
}
