package com.example.springmongo.demomongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {

  public List<Book> findByAuthorName(String name);
  
}
