package com.example.First;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {
  
  DBUser db = new DBUser();
   
  //http://localhost:8082/search?s=ss  --> Query parameter
  @GetMapping("/search")
  public String search(@RequestParam String s) {
    return "s";
  }
  
  @RequestMapping(path = "/hello", method = RequestMethod.GET)
  public String Hello() {
    return "hello";
  }

  //http://localhost:8082/user/{id}  --> Path parameter
  //http://localhost:8082/user/2
  @GetMapping("/user/{id}")
  public User getAUserByID(@PathVariable int id) {
    return db.getAUserByID(id);
  }
  
  //http://localhost:8082/user?q=Shubham  --> Query Parameter
  @GetMapping("/user")
  public User getAUserByName(@RequestParam String q) {
    return db.getAUserByName(q);
  }
  
  @GetMapping("/userre")
  public ResponseEntity<User> getAUserByNameResponseEntity(@RequestParam String q) {
    User user = db.getAUserByName(q);
    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add("server", "good");
    HttpStatus status = HttpStatus.ACCEPTED;
    return new ResponseEntity<User>(user,headers,status);
  }
  
  //http://localhost:8082/user
  @GetMapping("/users")
  public List<User> getAllUser() {
    return db.getAllUser();
  }
   
  /*
   * Default constructor is expected of user class here
   * PostMan Body tab input
   *    {
        "id":4,
        "name":"sahil",
        "age":45
        }
   */
  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)   //status : 201 created
  public User createUser(@RequestBody User user) {
    db.addUser(user);
    return user;
  }
  
  @DeleteMapping("/users/{id}")
  public boolean deleteUser(@PathVariable int id) {
    return db.deleteUser(id);
  } 
  
  
  RestTemplate restTemplate = new RestTemplate();

  
  @RequestMapping("/gitHub/users/{login}")
  public ResponseEntity<GitHubUser> get(@PathVariable("login") String login){

      ResponseEntity<GitHubUser> response = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GitHubUser.class);
      System.out.println(response.getHeaders());
      System.out.println(response.getStatusCode());
      GitHubUser gitHubUser = response.getBody();
      System.out.println(gitHubUser.toString());
      return response;
  } 
}