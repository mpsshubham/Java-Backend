package com.example.demosecurityjpa.demosecurityjpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String userName;
  private String password;
  private boolean isActive;
  String authorities;
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> auth_list=new ArrayList<>();
    String[] split = this.authorities.split(":");
    for(String s:split) {
      GrantedAuthority obj = new SimpleGrantedAuthority(s);
      auth_list.add(obj);
    }
    return auth_list;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return this.isActive;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User(String userName, String password, boolean isActive, String authorities) {
    this.userName = userName;
    this.password = password;
    this.isActive = isActive;
    this.authorities = authorities;
  }

  public User() {
  }
}