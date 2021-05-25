package com.example.jpa2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String authorName;
  private int cost;
  
  //@Joincolumn will merge only primary id of the other table in this table 
  @ManyToOne
  @JoinColumn
  private BookCategory bookCategory;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getAuthorName() {
    return authorName;
  }
  
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
  
  public int getCost() {
    return cost;
  }
  
  public void setCost(int cost) {
    this.cost = cost;
  }

  public BookCategory getBookCategory() {
    return bookCategory;
  }

  public void setBookCategory(BookCategory bookCategory) {
    this.bookCategory = bookCategory;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", name=" + name + ", authorName=" + authorName + ", cost=" + cost + "]";
  }
  
  public Book(int id, String name, String authorName, int cost) {
    this.id = id;
    this.name = name;
    this.authorName = authorName;
    this.cost = cost;
  }

  public Book() {
  }

  public Book(String name, String authorName, int cost) {
    super();
    this.name = name;
    this.authorName = authorName;
    this.cost = cost;
  }

  public Book(String name, String authorName, int cost, int bookCategory) {
    super();
    this.name = name;
    this.authorName = authorName;
    this.cost = cost;
    this.bookCategory = new BookCategory();
    this.bookCategory.setId(bookCategory);
  }
}