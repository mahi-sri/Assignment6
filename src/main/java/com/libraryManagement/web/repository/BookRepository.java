package com.libraryManagement.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.web.model.BookModel;

//Creating BookRepository for the CRUD operations
public interface BookRepository extends JpaRepository<BookModel, Integer> {
	
}
