package com.birthday.birthday.logic;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER")
                .and()
                .withUser("admin").password("password").roles("USER", "ADMIN");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/birthday/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/birthday/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/birthday/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/birthday/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }



}