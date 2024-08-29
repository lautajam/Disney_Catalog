package com.lautajam.api_disney_catalog.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> 
                authorizeRequests.anyRequest().permitAll()  // Permite acceso a todas las rutas
            )
            .csrf(csrf -> csrf.disable());  // Desactiva la protección CSRF

        return http.build();
    }
}

