package com.adns.fanpark.controllers;

import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adns.fanpark.entities.User;
import com.adns.fanpark.repositories.UserRepository;
import com.adns.fanpark.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	/*
	 *  @GetMapping("/") public String hello() { return "welcome"; }
	 */
	
	@GetMapping("/") 
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
		
		User updatedUser = userService.updateUser(id, user);

		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	
	@PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
    	System.out.println(user.getUserId() + user.getUserName());
    	User savedUser = userService.createUser(user);
    	
    	return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Map<String,String>> deleteUser(@PathVariable("userId") Integer id){
		User userDeleted = userService.deleteUserById(id);
		return new ResponseEntity<Map<String,String>>(Map.of("message","User deleted successfully!"),HttpStatus.OK);
	}
	 
}
