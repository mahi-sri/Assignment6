package com.libraryManagement.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Creating the author entity
@Entity
public class AuthorModel {
	
	//Declaring the fields
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int authorId;
	private String authorName;
	
	// Getters and Setters for the fields
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
