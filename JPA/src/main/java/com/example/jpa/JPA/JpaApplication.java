package com.example.jpa.JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
		
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//MyConfig class can be used to create lot of beans of different class
		//ctx.register(MyConfig.class);
		//ctx.refresh();
		//HelloWorld bean = ctx.getBean(HelloWorld.class);
		//HelloWorld bean2 = ctx.getBean(HelloWorld.class);
		//bean and bean2 have same address...singleton scope
		//change scope to prototype if different beans are required
		//System.out.println(bean+" "+bean2);
		//In actual we dont need to create applicationcontext, as if we create our own applicationcontext spring will also create webapplicationcontext
		//and while autowiring we will not get same object
	}
}
