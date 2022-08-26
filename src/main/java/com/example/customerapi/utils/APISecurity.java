package com.example.customerapi.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Order(1)
@EnableWebSecurity
public class APISecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().anyRequest().permitAll().and()
                .csrf().disable().cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }

//    @Bean
//    public WebMvcConfigurer corsConfigure() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
//            }
//        };
//    }

}
