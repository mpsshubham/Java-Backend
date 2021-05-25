package com.example.jdbc.JDBC.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.JDBC.DAOs.Person;
import com.example.jdbc.JDBC.DBManager.DBOperations;
import com.example.jdbc.JDBC.Requests.CreateRequest;

@RestController
public class PersonController {
  
  @RequestMapping(value = "/getPersons", method = RequestMethod.GET)
  public List<Person> getPersons() throws SQLException {
    return DBOperations.getPersons();
  }
  
  @RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
  public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
    DBOperations.insertPerson(request);
  }
   
  @RequestMapping(value = "/createTable", method = RequestMethod.POST)
  public void createTable(@RequestParam String q) throws SQLException {
    DBOperations.createTable(q);
  }
}