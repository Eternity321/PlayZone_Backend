package com.playzone.user.api.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record UserRequest(
    @NotEmpty String login,
    @NotEmpty String password,
    @NotEmpty String firstName,
    @NotEmpty String lastName
) {
}
