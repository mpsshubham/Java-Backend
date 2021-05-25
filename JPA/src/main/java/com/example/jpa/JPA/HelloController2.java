package com.example.jpa.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {

  
  @Autowired
  HelloWorld hello;
  
  @GetMapping("/func2")
  public void func() {
    System.out.println(hello);
  }
}
