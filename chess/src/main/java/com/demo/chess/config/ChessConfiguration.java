package com.demo.chess.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class ChessConfiguration {

//    @Autowired
//    private AuthorizedFilter authorizedFilter;
//
//    @Bean
//    public SecurityFilterChain security(HttpSecurity httpSecurity) throws Exception{
//
//        httpSecurity
//                .sessionManagement().disable()
//                .formLogin().disable()
//                .authorizeHttpRequests((request) -> {
//                    request
//                            .requestMatchers("/login", "/register").permitAll()
//                            .requestMatchers("/api/**").authenticated();
//                })
//                .addFilterBefore(authorizedFilter, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic();
//
//        return httpSecurity.build();
//    }
}
