package com.example.First;

import java.util.ArrayList;
import java.util.List;

public class DBUser {
  
  private List<User> userTable = new ArrayList<User>();
  
  public DBUser() {
    userTable.add(new User(1,"Shubham",24));
    userTable.add(new User(2,"Rahul",30));
    userTable.add(new User(3,"Arun",22));
  }
  
  public List<User> getAllUser() {
    return userTable;
  }
  
  public User getAUserByID(int id) {
    for(User user:userTable) {
      if(user.getId()==id) {
        return user;
      }
    }
    return null;
  }
  
  public User getAUserByName(String name) {
    for(User user:userTable) {
      if(user.getName().equals(name)) {
        return user;
      }
    }
    return null;
  }
  
  public User addUser(User user) {
    userTable.add(user);
    return user;
  }
  
  public boolean deleteUser(int id) {
    for(User user:userTable) {
      if(user.getId()==id) {
        userTable.remove(user);
        return true;
      }
    }
    return false;
  }
}