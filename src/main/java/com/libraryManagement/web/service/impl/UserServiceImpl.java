package com.libraryManagement.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.libraryManagement.web.model.LibrarianModel;
import com.libraryManagement.web.repository.UserRepository;
import com.libraryManagement.web.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	// Constructor
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	// Method to validate the user
	public boolean validateUser(String username, String password) {
		
		// Fetching all users from the database
		List<LibrarianModel> users = userRepository.findAll();
		
		// Iterating over each user and checking for the valid user
		for(LibrarianModel user: users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}

	
	
}
