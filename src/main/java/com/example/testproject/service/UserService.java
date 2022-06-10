package com.example.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testproject.model.User;
import com.example.testproject.repository.UserRepositoryInterface;

@Service
public class UserService {
	@Autowired
	private UserRepositoryInterface repo;
	
	public User findUserByName(String userName) {
		return repo.findByName(userName);
	}
}
