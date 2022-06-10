package com.example.testproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testproject.exception.UserNotFoundException;
import com.example.testproject.model.User;
import com.example.testproject.repository.UserRepositoryInterface;
import com.example.testproject.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepositoryInterface repo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/user")
	public List<User> getAllUser() {
		return repo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) throws UserNotFoundException {
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@GetMapping("/findUser")
	public User findUserByName(@RequestParam String name) {
		return userService.findUserByName(name);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable Integer id) {
		repo.deleteById(id);
	}
	
	@PutMapping("user/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User newUser){
		User usr = repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		usr.setName(newUser.getName());
		usr.setWeight(newUser.getWeight());
		return repo.save(usr);
	}
	
}
