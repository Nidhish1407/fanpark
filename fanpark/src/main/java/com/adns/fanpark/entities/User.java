package com.adns.fanpark.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="user_details")
public class User {
	
	/*
	 * User is reserved keyword in JPA
	 * 
	 * Java uses camelcase but Spring JPA Hibernate uses underscore
	 *
	 * camel case converted into underscore in database - userName to user_name
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name",unique = true, nullable = false)
	private String userName;
	
	public User() {};
	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
