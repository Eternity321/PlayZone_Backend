package com.playzone.user.api.mapper;

import com.playzone.user.api.dto.request.UserRequest;
import com.playzone.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Преобразование DTO в сущность
    User toEntity(UserRequest request);

    // Преобразование сущности в DTO
    // UserResponse toDto(User entity);

    // Преобразование сущности в DTO запроса (если необходимо)
    UserRequest toRequestDto(User entity);
}
