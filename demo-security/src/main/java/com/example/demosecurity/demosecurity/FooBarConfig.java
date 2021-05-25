package com.example.demosecurity.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter{

  //This is for authentication
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
    .withUser("shubham")
    .password("sharma")
    .roles("admin_role")
    .and()
    .withUser("rahul")
    .password("singh")
    .roles("student_role");
  }
 
  //This is for authorization
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.
    httpBasic()
    .and()
    .authorizeRequests()
    .antMatchers("/admin**").hasRole("admin_role")
    .antMatchers("/student/**").hasAnyRole("student_role","admin_role")
    .antMatchers("/**").permitAll()
    .and()
    .formLogin();
  }
  
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

}