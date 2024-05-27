/*package com.ghacham.basketball.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/*
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
    
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/secured/**").authenticated();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())
                .build();
         return http.build();
            }
/*
    
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/coaches").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic()
            .and()
            .csrf().disable();

        return http.build();
    }

    
    public UserDetailsService userDetailsService() {
        UserDetails coach = User.builder()
            .username("coach")
            .password(passwordEncoder().encode("password"))
            .roles("COACH")
            .build();

        UserDetails player = User.builder()
            .username("player")
            .password(passwordEncoder().encode("password"))
            .roles("PLAYER")
            .build();

        return new InMemoryUserDetailsManager(coach, player);
    }

    
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/
