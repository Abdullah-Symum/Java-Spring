package com.symum.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // Add support for JDBC ...
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }

    // Restricting Access
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer
                -> configurer
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        // Use HTTP BAsic authentication
        http.httpBasic();

        // Disable cross site request forgery (CSRF)
        // in general, not required for stateless RestAPI that use post,put,delete or patch.
        http.csrf().disable();

        return http.build();
    }


    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}abc123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}abc123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails shahid = User.builder()
                .username("shahid")
                .password("{noop}abc123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        UserDetails kabir = User.builder()
                .username("kabir")
                .password("{noop}abc123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(john,mary,shahid, kabir);
    }

     */

}
