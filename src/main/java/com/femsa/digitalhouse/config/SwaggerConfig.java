package com.femsa.digitalhouse.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    protected OpenAPI getApiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Digital House API")
                        .description("Digital House Service")
                        .version("1.0"));
    }
}
