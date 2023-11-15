package com.example.ProyectoBancoJPA.Swagger;

import io.jsonwebtoken.Jwt;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Your API Title")
                        .version("1.0")
                );
    }

    @RestController
    @RequestMapping("/api")
    public class ApiController {

        @GetMapping("/hello")
        public String hello(@AuthenticationPrincipal Jwt jwt) {
            return "Hello, " +  "!";
        }
    }
}