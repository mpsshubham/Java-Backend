package com.example.jpa2.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  private String name;
  
  // one bookcategory(owing class) many(property) books 
  @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
  private Set<Book> books;

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

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public BookCategory(String name) {
    this.name = name;
  }

  public BookCategory(String name, Set<Book> books) {
    this.name = name;
    this.books = books;
    this.books.forEach(x -> x.setBookCategory(this));
  }

  @Override
	public String toString() {
		return "BookCategory [id=" + id + ", name=" + name + ", books=" + books + "]";
	}

public BookCategory() {
  } 
}