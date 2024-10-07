package com.acer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    //now add spring security dependency and change version 3.0.0 because compatibility issue
   public SecurityFilterChain securityFilterChain(
           HttpSecurity http
   ) throws Exception {
       http.csrf().disable().cors().disable();
       http.authorizeHttpRequests().anyRequest().permitAll();
      return http.build();
   }


}
