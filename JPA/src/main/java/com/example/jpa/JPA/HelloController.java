package com.example.jpa.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  
  @Autowired
  HelloWorld hello;
  
  @GetMapping("/func")
  public void func() {
    System.out.println(hello);
  }

}
