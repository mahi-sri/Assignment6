package com.libraryManagement.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Creating the librarian entity
@Entity
public class LibrarianModel {
	
	//Declaring the fields
	@Id
	private String username;	
	private String password;
	
	// Contructor
	public LibrarianModel() {
		super();
	}
	
	// Getters and Setters for the fields
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
}
