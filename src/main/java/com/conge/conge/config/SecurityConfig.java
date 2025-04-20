package com.conge.conge.config;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/connexion", "/css/**", "/js/**").permitAll() // la page de login est publique
//                 .anyRequest().authenticated() // tout le reste est sécurisé
//             )
//             .formLogin(login -> login
//                 .loginPage("/connexion") // page personnalisée de connexion
//                 .defaultSuccessUrl("/users/list", true) // après connexion
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutSuccessUrl("/connexion?logout") // redirection après déconnexion
//                 .permitAll()
//             );

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();
//     }
// }