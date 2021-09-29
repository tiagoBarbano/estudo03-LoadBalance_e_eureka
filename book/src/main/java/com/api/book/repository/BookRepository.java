package com.api.book.repository;

import com.api.book.model.BookModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long>{
    
}
