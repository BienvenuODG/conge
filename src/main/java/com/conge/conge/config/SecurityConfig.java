package com.conge.conge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/login", "/css/**", "/js/**").permitAll() // accessibles sans login
                .anyRequest().authenticated() // tout le reste nécessite d’être connecté
            )
            .formLogin(login -> login
                .loginPage("/users/login") // ta page de connexion
                .defaultSuccessUrl("/users/list", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/users/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
