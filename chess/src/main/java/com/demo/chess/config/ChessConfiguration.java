package com.demo.chess.config;

import com.demo.chess.filter.AuthorizedFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ChessConfiguration {

    @Autowired
    private AuthorizedFilter authorizedFilter;

    @Bean
    public SecurityFilterChain security(HttpSecurity httpSecurity) throws Exception{


        return  httpSecurity.csrf().disable()
                .cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .formLogin().disable()
                .authorizeHttpRequests((request) -> {
                    request
                            .requestMatchers("/login", "/register").permitAll()
                            .requestMatchers("/api/**").authenticated();
                })
                .addFilterBefore(authorizedFilter, UsernamePasswordAuthenticationFilter.class)

                .httpBasic().and().build();

        //return httpSecurity.build();

    }
}
