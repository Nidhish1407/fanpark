package com.adns.fanpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adns.fanpark.entities.User;
import com.adns.fanpark.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	  //Autowired Internal
	  public UserService(UserRepository userRepository) { 
	      this.userRepository = userRepository; 
	  }
	  
	 */
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User deleteUserById(Integer id) {
		
		User userToDelete = userRepository.findById(id).orElse(null);
		
		if(userToDelete == null) {
			// throw custom exception
			return null;
		}
		
		userRepository.deleteById(id);
		
		return userToDelete;
	}
	
}
