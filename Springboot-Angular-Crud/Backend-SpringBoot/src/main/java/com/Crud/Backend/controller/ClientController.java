package com.Crud.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Crud.Backend.model.User;
import com.Crud.Backend.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String helloworld() {
		return "Hello World!";
	}
	
	@PostMapping("/add")
	public User createUSer(@RequestBody User user) {
		User u=userService.createUser(user);
		return u;
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PutMapping("/update/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable("id") long id) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable() long id) {
		 userService.deleteUser(id);
		return null;
		 
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id); 
	}
	
	
	
}
