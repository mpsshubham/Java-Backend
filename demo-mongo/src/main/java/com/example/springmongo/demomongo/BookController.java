package com.example.springmongo.demomongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  
  @Autowired
  BookRepository bookRepository;
  
  @GetMapping("/getBooks")
  public List<Book> getBook() {
    return bookRepository.findAll();
  }
  
  @PostMapping("/insertBook")
  public void insertBook(@RequestBody CreateRequest request) {
    Book book = new Book(request.getName(),request.getAuthorName(),request.getCost());
    bookRepository.save(book);
  }
  
  @GetMapping("/getBookByAuthor")
  public List<Book> getBookByAuthorName(@RequestParam("name") String name) {
    return bookRepository.findByAuthorName(name);
  }

}
