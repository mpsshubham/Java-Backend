package com.sample.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    RedisTemplate redisTemplate;
    
    //this is not key of user, this is hashmap name
    private static final String KEY = "user";
    /*
    id: 1
    name: Ramu
    age : 25
    
    this will be stored as 
    Ramu : (Obj)
     */

    public Boolean saveUser(User user) {
        try {
            Map userHash = new ObjectMapper().convertValue(user, Map.class);
            redisTemplate.opsForHash().put(KEY, user.getName(), userHash);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findByName(String name) {

        Map userMap = (Map) redisTemplate.opsForHash().get(KEY, name);
        User user = new ObjectMapper().convertValue(userMap, User.class);
        return user;
    }

}
