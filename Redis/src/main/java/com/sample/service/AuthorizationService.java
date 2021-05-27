package com.sample.service;

import com.sample.dao.User;


public interface AuthorizationService {

    public Boolean saveUser(User user);

    public User findByName(String name);

}
