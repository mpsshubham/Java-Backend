package com.example.jpa.JPA;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
  
  @Bean
  @Scope("prototype")
  public HelloWorld getHelloWorldObject() {
    return new HelloWorld("shubham","sharma");
  }

}
