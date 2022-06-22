package com.libraryManagement.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.web.model.LibrarianModel;

//Creating UserRepository for the CRUD operations
public interface UserRepository extends JpaRepository<LibrarianModel, String> {

}
