package com.sample.dao;

public interface UserDao {

    public Boolean saveUser(User user) ;
    public User findByName(String name) ;
    
}
