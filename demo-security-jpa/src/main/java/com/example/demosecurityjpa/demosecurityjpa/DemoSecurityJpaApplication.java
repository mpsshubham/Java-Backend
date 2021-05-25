package com.example.demosecurityjpa.demosecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSecurityJpaApplication implements CommandLineRunner {

  @Autowired
  UserRepository repo;
  
	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityJpaApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
	 //Bcrypted password for sharma, singh
     User user = new User("shubham","$2y$10$eyr7wVYFjY45cAqCeREOhuMv1CdVA2jOq/o6diGFRkJ5vreMEyFFq",true,"admin:student");
     User user1 = new User("rahul","$2y$10$DkH0Wg2e6WTZLI4cz/LJMer2wS37FHEz8l4zkigWieHVOIxXpDgq2",true,"student");
     repo.save(user);
     repo.save(user1);

  }

}
