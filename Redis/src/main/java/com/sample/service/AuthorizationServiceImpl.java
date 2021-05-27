package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.User;
import com.sample.dao.UserDao;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    UserDao userDao;

    public Boolean saveUser(User user){
        System.out.println("Calling saveUser method");
        return userDao.saveUser(user) ;
    }

    @Override
    public User findByName(String name) {
        System.out.println("Calling findByName method");

        return userDao.findByName(name);
    }
}
