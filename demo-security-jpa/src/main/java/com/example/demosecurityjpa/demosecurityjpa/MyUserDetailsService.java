package com.example.demosecurityjpa.demosecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


  @Autowired
  UserRepository repo;
  
  @Override
  public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
    return repo.findByuserName(arg0);
  }

}
