package com.adns.fanpark.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adns.fanpark.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//public List<User> findByUsername(String userName);
}
