package com.example.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testproject.model.User;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
	
	User findByName(String name);
}
