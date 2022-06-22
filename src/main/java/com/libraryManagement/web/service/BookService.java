package com.libraryManagement.web.service;

import java.util.List;

import com.libraryManagement.web.model.BookModel;

// Creating an interface for BookService
public interface BookService {
	
	List<BookModel> getAllBooks();
	BookModel getBook(int bookCode);
	void addBook(int bookCode, String bookName, String author);
	void updateBook(int bookCode, String newBookName, String newAuthor);
	void deleteBook(int bookCode);
}
