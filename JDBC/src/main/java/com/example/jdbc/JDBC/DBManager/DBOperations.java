package com.example.jdbc.JDBC.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.JDBC.DAOs.Person;
import com.example.jdbc.JDBC.Requests.CreateRequest;

public class DBOperations {
  
  //volatile so that all thread same variable, if one thread make connection open, all thread will use that value
  private static volatile Connection connection;
  
  public static Connection getConnection() throws SQLException {  
    //double check for multiple thread
    //if second check is not there, then there is chance that one thread has made the connection and other thread was at
    // synchronized line and then it will also create connection
    if(connection==null) {
      synchronized (DBOperations.class) {        
        if(connection==null) {
          connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/temp", "admin", "password");
        }        
      }
    }
    return connection; 
  }
  
  public static void closeConnection() throws SQLException {
    if(connection!=null) {
      synchronized (DBOperations.class) {        
        if(connection!=null) {
          connection=null;    // connection.close() does not make it null
        }        
      }
    }
  }
  
  public static void createTable(String name) throws SQLException {
    getConnection();
    Statement statement = connection.createStatement();
    boolean isCreated = statement.execute("CREATE TABLE "+name+" ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), age int, address VARCHAR(30))");   
    if(isCreated) {
      System.out.println("Table "+name+" sucessfully created");
    }
    closeConnection();
  }
  
  public static void insertPerson(CreateRequest request) throws SQLException {    
    getConnection();  
    PreparedStatement statement = connection.prepareStatement("INSERT INTO person VALUES (null,?,?,?)");
    statement.setString(1, request.getName());
    statement.setInt(2, request.getAge());
    statement.setString(3, request.getAddress());
    int rowsAffected = statement.executeUpdate();
    if(rowsAffected>0) {
      System.out.println("Successfully inserted into table");
    }
    else {
      System.out.println("Unable to insert in table");
    }
    closeConnection();
  }
  
  public static List<Person> getPersons() throws SQLException {
    getConnection();
    Statement createStatement = connection.createStatement();
    ResultSet rs = createStatement.executeQuery("SELECT * FROM person");
    List<Person> persons = new ArrayList<>();
    while(rs.next()) {
      int id = rs.getInt(1);
      String name = rs.getString(2);
      int age = rs.getInt(3);
      String address = rs.getString(4);
      
      Person person = new Person(id,name,age,address);
      persons.add(person);
      System.out.println(person);
    }
    closeConnection();
    return persons;
  }
}