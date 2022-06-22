package com.libraryManagement.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libraryManagement.web.constants.Constants;
import com.libraryManagement.web.exception.ResourceNotFoundException;
import com.libraryManagement.web.model.AuthorModel;
import com.libraryManagement.web.model.BookModel;
import com.libraryManagement.web.repository.AuthorRepository;
import com.libraryManagement.web.service.BookService;
import com.libraryManagement.web.service.UserService;

@Controller
public class LibraryManagementController implements Constants {
	
	// Instance variables
	private UserService userService;
	private BookService bookService;
	private AuthorRepository authorRepository;
	ModelAndView mv;
	
	// Constructor
	@Autowired
	public LibraryManagementController(UserService userService, BookService bookService, AuthorRepository authorRepository) {
		super();
		this.userService = userService;
		this.bookService = bookService;
		this.authorRepository = authorRepository;
		this.mv = new ModelAndView();
	}
	
	// Handler method to redirect it to the login page
	@GetMapping("/")
	public ModelAndView getLogin() {
		
		// Setting the view name for ModelAndView object
		mv.setViewName("index");
		
		return mv;
	}
	
	// Handler method to validate user
	@PostMapping("/login")
	public ModelAndView validateLibrarian(String username, String password, HttpSession session) {
		
		String showError = "false";
		
		// Checking for the right user
		if(userService.validateUser(username, password)) {
			
			// Setting the username for the current session
			session.setAttribute("user", username);
			
			// Setting the parameters for ModelAndView object
			mv.addObject("user", username);
			mv.setViewName("redirect:/books");
		}
		else {
			    
			// Setting the error message
			String msg = String.format("Librarian is not exist with Username : %s", username);
			
			// For invalid user throwing the exception
			throw new ResourceNotFoundException(msg);
		}
		
		return mv;
	}
	
	// Handler method to logout
	@PostMapping("/logout")
	public ModelAndView getLogout(HttpServletRequest request) {
		
		// Fetching the current session and removing the set attributes and invalidate it
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		// Setting the view name for ModelAndView object
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	// Handler method to list books and return view
	@GetMapping("/books")
	public ModelAndView listAllBooks() {
		
		// Setting the parameters for ModelAndView object
		mv.addObject("books", bookService.getAllBooks());
		mv.setViewName("bookManagement");
		
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView createBookForm() {
		
		// Fetching the list of all authors from the database
		List<AuthorModel> authors = authorRepository.findAll();
		
		// Setting the parameters for ModelAndView object
		mv.addObject("authors", authors);
		mv.setViewName("createBookForm");
		
		return mv;
		
	}
	
	@PostMapping("/add")
	public ModelAndView saveBook(int bookCode, String bookName, String author) {
		
		// Adding book in the database
		bookService.addBook(bookCode, bookName, author);
		
		// Setting the parameters for ModelAndView object
		mv.setViewName("redirect:/books");
		
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView createEditForm(int bookCode) {
				
		// Fetching the list of all authors from the database
		List<AuthorModel> authors = authorRepository.findAll();
		
		// Setting the parameters for ModelAndView object
		mv.addObject("authors", authors);
		mv.addObject("book", bookService.getBook(bookCode));
		mv.setViewName("editBookForm");
		
		return mv;
		
	}
	
	@RequestMapping("/update")
	public ModelAndView editBook(String newBookName, String newAuthor, HttpSession session) {
		
		// Fetching bookCode from the view
		Integer bookCode = (Integer)session.getAttribute("bookCode");
		
		// Updating the existing book information
		bookService.updateBook(bookCode, newBookName, newAuthor);
		
		// Setting the view name for ModelAndView object
		mv.setViewName("redirect:/books");
		
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView removeBook(int bookCode) {
		
		// Deleting the book information
		bookService.deleteBook(bookCode);
		
		// Setting the view for ModelAndView object
		mv.setViewName("redirect:/books");
		return mv;
	}
}
