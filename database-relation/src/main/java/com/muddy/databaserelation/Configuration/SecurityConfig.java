package com.muddy.databaserelation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.csrf().disable()
                 .authorizeHttpRequests((authorize)->
                         authorize.requestMatchers("/index").permitAll()
                                 .requestMatchers("about").permitAll()
                                 .requestMatchers("community").permitAll()
                                 .requestMatchers("/contact").permitAll()
                 ).formLogin(
                         form->form
                                 .loginPage("/login")
                                 .loginProcessingUrl("/login")
                                 .defaultSuccessUrl("home",true)
                                 .permitAll()
                 ).logout(
                         logout->logout
                                 .invalidateHttpSession(true)
                                 .clearAuthentication(true)
                                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                 .logoutSuccessUrl("/login?logout")
                                 .permitAll()
                 );
         return http.build();
     }
}

