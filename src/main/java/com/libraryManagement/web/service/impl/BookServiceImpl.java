package com.libraryManagement.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.libraryManagement.web.exception.ResourceNotFoundException;
import com.libraryManagement.web.model.BookModel;
import com.libraryManagement.web.repository.BookRepository;
import com.libraryManagement.web.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	// Constructor
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	// Method to fetch all available books from the database
	public List<BookModel> getAllBooks() {
		
		return bookRepository.findAll();
	}

	// Method to fetch particular book from the database on the basis of bookCode
	public BookModel getBook(int bookCode) {
		
		// Checking whether bookCode is exist in the database and return a book object
		Optional<BookModel> book = bookRepository.findById(bookCode);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			
			// Setting the error message
			String msg = String.format("Book not found with Book Code : %s", bookCode);
			
			// If book is not present then throwing the exception
			throw new ResourceNotFoundException(msg);
		}
		
	}
	
	// Method to add new book in the database if it is not present
	public void addBook(int bookCode, String bookName, String author) {
		
		// Check if book is already present or not? 
		boolean isExist = bookRepository.existsById(bookCode);
		
		// If not exist
		if(!isExist) {
			
			// then creating a new book object and set all the details
			BookModel newBook = new BookModel();
			newBook.setBookCode(bookCode);
			newBook.setBookName(bookName);
			newBook.setAuthor(author);
			
			// Saving new book to the database
			bookRepository.save(newBook);
		}
		else {
			
			// Setting the error message
			String msg = String.format("Book is already exist with Book Code : %s", bookCode);
			
			// If book is not present then throwing the exception
			throw new ResourceNotFoundException(msg);
		}
		
	}

	// Method to update the existing book record 
	public void updateBook(int bookCode, String newBookName, String newAuthor) {
		
		// Creating newBook object 
		BookModel newBook = new BookModel();
		
		// Fetching the existing book
		BookModel book = this.getBook(bookCode);
		
		// Setting the oldBook details into newBook with updation
		newBook.setBookCode(bookCode);
		newBook.setBookName(newBookName);
		newBook.setAuthor(newAuthor);
		newBook.setUpdatedOn(book.getUpdatedOn());
		
		// Deleting the oldBook
		this.deleteBook(bookCode);
		
		// Saving the information of updated book
		bookRepository.save(newBook);
	}
	
	// Method to delete the existing book record from the database
	public void deleteBook(int bookCode) {
		
		// Deleting the book record from the database
		bookRepository.deleteById(bookCode);
	}


	
}
