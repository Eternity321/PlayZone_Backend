package com.playzone.user;

import com.playzone.user.config.ApplicationConfig;
import com.playzone.user.config.KeycloakProperties;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({KeycloakProperties.class, ApplicationConfig.class})
@SecurityScheme(
    name = "Keycloak",
    openIdConnectUrl = "${keycloak.openid-connect-url}",
    scheme = "bearer",
    type = SecuritySchemeType.OPENIDCONNECT,
    in = SecuritySchemeIn.HEADER
)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
