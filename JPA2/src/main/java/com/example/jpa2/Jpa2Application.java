package com.example.jpa2;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa2.models.Book;
import com.example.jpa2.models.BookCategory;
import com.example.jpa2.repsository.BookCategoryRepository;
import com.example.jpa2.repsository.BookRepository;

@SpringBootApplication
public class Jpa2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Jpa2Application.class, args);
	}

	//CommandLine Runner run functions execute on startup, helps in testing code faster without needing to create API,
	//can also be used for startup activites, creating/deleting temp files, executed only once
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookCategoryRepository bookCategoryRepository;
	
    public void run(String... args) throws Exception {
      
//      Book b = new Book(3,"adsa","eqweq",222);
//      bookRepository.save(b);
      
//      System.out.println(bookRepository.findAll());
//      System.out.println(bookRepository.findByAuthorName("jgf"));
//      System.out.println(bookRepository.findByid(2));
//      System.out.println(bookRepository.findByAuthor("jlk"));
//      System.out.println(bookRepository.findByAuthors("jlk"));

      
      Set<Book> books = new HashSet<Book>();
      Book b1 = new Book("Python","abc",200);
      Book b2 = new Book("C++","def",400);
      books.add(b1);
      books.add(b2);
      bookCategoryRepository.save(new BookCategory("Programming Languages"));
      bookCategoryRepository.save(new BookCategory("Non Programming Languages", books));
      
      
      //System.out.println(bookCategoryRepository.findById(1)); //----> Very Imp
      // if we have toString method for bookcategory and printing books also in that toString
      // then above line will throw error as above line as it is not able to fetch books and we will get lazy initialization error
      // if we dont do System.out.println(); then there will be no error, only while printing books there will be error
      // so to remove that we have to make fetch type eager in bookCategory class above List<books> but that will be costly
      // as it will load books also in memory in advance

    }
}