package com.sample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.sample.dao.User;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
@EnableRedisRepositories
@EnableCaching
public class AuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);

	}

}

