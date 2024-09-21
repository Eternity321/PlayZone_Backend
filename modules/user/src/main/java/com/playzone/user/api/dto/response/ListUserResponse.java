package com.playzone.user.api.dto.response;

import com.playzone.user.model.User;
import java.util.List;

public record ListUserResponse(
    List<User> users,
    Integer size
) {
}
