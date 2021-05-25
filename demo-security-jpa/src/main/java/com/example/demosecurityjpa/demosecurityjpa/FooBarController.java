/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package com.example.demosecurityjpa.demosecurityjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {
  
  //This require authentication and authorization
  @GetMapping("/student")
  public String getStudent() {
    return "hello student";
  }
  
  //This require authentication and authorization
  @GetMapping("/admin")
  public String getAdmin() {
    return "hello admin";
  }
  
  //This api doesnt require authentication and authorization
  @GetMapping("/visitor")
  public String getVisitor() {
    return "hello visitor";
  }

}
