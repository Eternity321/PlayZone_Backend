package com.playzone.user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(ApplicationConfig applicationConfig) {
        return new OpenAPI()
            .info(new Info().title("PlayZone")
                .version("1.0")
                .description("API PlayZone"))
            .addServersItem(new Server().url(applicationConfig.baseSwaggerUrl()));
    }
}
