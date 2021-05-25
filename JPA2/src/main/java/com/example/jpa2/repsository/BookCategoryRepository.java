package com.example.jpa2.repsository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa2.models.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

}
