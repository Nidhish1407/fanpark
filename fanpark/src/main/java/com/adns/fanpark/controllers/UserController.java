package com.adns.fanpark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adns.fanpark.entities.User;
import com.adns.fanpark.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/") public String hello() { return "welcome"; }
	 */
	
	@GetMapping("/") 
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	
	 
}
