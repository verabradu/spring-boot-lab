// Pachetul in care se afla clasa
package com.example.springbootlab;

// Permite definirea unui obiect string(bean)
import org.springframework.context.annotation.Bean;

// Marcheaza clasa ca fiind o clasa de configurare spring
import org.springframework.context.annotation.Configuration;

// Clasa care permite configurarea regulilor de securitate pentru HTTP
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// Interfata care defineste lantul de filtre de securitate
import org.springframework.security.web.SecurityFilterChain;

// Indica faptul ca aceasta este o clasa de configurare Spring
@Configuration
public class SecurityConfig {

    // Metoda care va returna un bean gestionat de Spring (un obiect reutilizabil)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configurarea autorizatilor pentru request-uri HTTP
                .authorizeHttpRequests(auth -> auth
                        // Oricine poate accesa ruta/public fara autentificare
                        .requestMatchers("/public").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()); // Se activeaza login-ul cu formular web(default HTML logon page)

        return http.build();
    }
}