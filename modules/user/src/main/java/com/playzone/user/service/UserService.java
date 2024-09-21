package com.playzone.user.service;

import com.playzone.user.api.dto.request.PasswordUpdateRequest;
import com.playzone.user.api.dto.request.UserRequest;
import com.playzone.user.exception.NotFoundException;
import com.playzone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.playzone.user.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final KeycloakService keycloakService;

    public void createUser(UserRequest userRequest) {
        User user = keycloakService.registrationUser(userRequest);
        userRepository.save(user);
    }

    public List<User> getAllUsers(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest).getContent();
    }

    public User getUser(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с данным id не найден!"));
    }

    public void changePassword(PasswordUpdateRequest request, UUID userId) {
        keycloakService.changePassword(request, userId);
    }
}
