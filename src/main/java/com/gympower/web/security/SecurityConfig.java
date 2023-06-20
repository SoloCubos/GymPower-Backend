package com.gympower.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(config -> config.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/index", "/register").permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .httpBasic()
                .and()
                .build();
    }
    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("Juan")
                               .password("1234")
                               .roles()
                               .build());

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                           .userDetailsService(userDetailsService())
                           .passwordEncoder(passwordEncoder)
                           .and().build();
    }

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                            .authorizeHttpRequests(auth -> {
                                auth.requestMatchers("/login");
                                auth.anyRequest().authenticated();
                            })
                            .formLogin().successHandler(successHandler())//redireccionamiento despues de iniciar sesion
                                        .permitAll()
                            .and()
                            .sessionManagement()
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//ALWAYS crear sesion siempre y cuando no exista ninguna, si hay una sesion existente, la rehutiliza
                                .invalidSessionUrl("/login")// IF_Required, crea la sesion si no existe y si es necesario o la reutiliza - NEVER, no crea ninguna session, y si ya existe una, la rehutiliza, en caso de no haber, hace una soliciutd
                                .maximumSessions(1)//Stateless. Sessiones independientes
                                .expiredUrl("/login")
                                .sessionRegistry(sessionRegistry())
                            .and()
                            .sessionFixation()
                                .migrateSession()
                            .and()
                            .httpBasic()
                            .and()
                            .build();
    }*/
/*
    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authentication) -> {
            response.sendRedirect("/session");
        });
    }*/
}

