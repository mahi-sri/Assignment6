package com.libraryManagement.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.web.model.AuthorModel;

// Creating AuthorRepository for the CRUD operations
public interface AuthorRepository extends JpaRepository<AuthorModel, Integer> {

}
