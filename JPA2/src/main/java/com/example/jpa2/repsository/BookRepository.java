package com.example.jpa2.repsository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jpa2.models.Book;

/**
 * 
 * To write own function implement BookRepository and annotate with @Repository
 * or annotate your func with @Query annotation
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

//  @Query("SELECT * FROM book WHERE book.name=name")
//  List<Book> findByName(String name);
    //findByproperty in Book.java
//    List<Book> findByAuthorName(String name);
//    Book findByid(int id);
  
  //Hibernate converts java object into sql table, camelcase property are converted to _
  //so we need to provide sql column name in query
  
  @Query(value = "select * from Book b where b.author_name=:my_name", nativeQuery = true)
   List<Book> findByAuthor(@Param("my_name")String my_name);
  
  @Query("select b from Book b where b.authorName=:my_name")
  List<Book> findByAuthors(@Param("my_name")String my_name);
}