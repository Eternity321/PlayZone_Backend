package com.playzone.user.service;

import com.playzone.user.api.dto.request.PasswordUpdateRequest;
import com.playzone.user.api.dto.request.UserRequest;
import com.playzone.user.config.KeycloakProperties;
import com.playzone.user.exception.KeycloakException;
import com.playzone.user.model.User;
import com.playzone.user.util.Credentials;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import org.keycloak.admin.client.Keycloak;
import java.util.Collections;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakService {

    private final Keycloak keycloak;
    private final KeycloakProperties keycloakProperties;

    public User registrationUser(UserRequest userRequest) {
        CredentialRepresentation credential = Credentials.createPasswordCredentials(userRequest.password());
        UserRepresentation user =new UserRepresentation();
        user.setEmail(userRequest.email());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);
        UsersResource instance = getInstance();
        Response response = instance.create(user);

        log.info("Response status: {}", response.getStatus());
        log.info("Response: {}", response);

        if (response.getStatus() != 201) {
            String error = response.readEntity(String.class);
            log.error("Failed to create user. Status: {}, Error: {}", response.getStatus(), error);
            throw new KeycloakException("Failed to create user: " + error);
        }

        String location = response.getHeaderString("Location");
        if (location == null || location.isEmpty()) {
            throw new KeycloakException("Failed to get user ID from response");
        }
        String userId = location.substring(location.lastIndexOf('/') + 1);
        log.info("User created with ID: {}", userId);

        User userRegistration = new User();
        userRegistration.setEmail(user.getEmail());
        userRegistration.setId(UUID.fromString(userId));
        userRegistration.setFirstName(userRequest.firstName());
        userRegistration.setLastName(userRequest.lastName());
        return userRegistration;
    }

    public void changePassword(PasswordUpdateRequest request, UUID userId) {
        RealmResource realmResource = keycloak.realm(keycloakProperties.realm());
        UsersResource usersResource = realmResource.users();
        UserResource userResource = usersResource.get(String.valueOf(userId));

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(request.password());

        userResource.resetPassword(passwordCred);
    }

    public UsersResource getInstance(){
        return keycloak.realm(keycloakProperties.realm()).users();
    }
}
