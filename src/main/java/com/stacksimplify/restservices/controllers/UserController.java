package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.services.UserService;

//Controller -
@RestController
@RequestMapping("/users")
public class UserController {
	
	//Autowire the UserService
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//getAllUsers Method
	@GetMapping
	public List<User> getAllUsers() {
		
		return userService.getAllUsers();
		
	}
	
	//Create User Method
	//@RequestBody Annotation
	//@PostMapping Annotation
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	//getUserById
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
		
	}
	
	//updateUserById
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	
	//deleteUserById
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	
	
	//getUserByUsername
	@GetMapping("/byusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}
	
	
	
	@PostMapping("/saludar")
	public ResponseEntity<String> holaOsmary(@RequestParam(name="nombre") String nombre){
		return new ResponseEntity<>(String.format("Hola %s", nombre), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
