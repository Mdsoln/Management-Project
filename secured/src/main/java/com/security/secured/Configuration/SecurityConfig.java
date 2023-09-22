package com.security.secured.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
     @Bean
    public static PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.csrf().disable()
                 .authorizeHttpRequests(authorize->
                         authorize.requestMatchers("/","/landing","/landing.html").permitAll()
                                 .requestMatchers("/about").permitAll()
                                 .requestMatchers("/community").permitAll()
                                 .requestMatchers("/cv/**").permitAll()
                                 .requestMatchers("index").permitAll()
                                 .requestMatchers("/register/**").permitAll()
                 ).formLogin(
                         form->form
                                 .loginPage("/login")
                                 .loginProcessingUrl("/login")
                                 .defaultSuccessUrl("/index",true)
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

     @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth
               .userDetailsService(userDetailsService)
               .passwordEncoder(passwordEncoder());
    }
}
