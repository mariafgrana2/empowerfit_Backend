package com.empowerfit.app.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empowerfit.app.model.User;
import com.empowerfit.app.service.UserService;


@CrossOrigin(origins = "*")
@Controller
@ResponseBody
@RequestMapping("/api/v1/users")  
public class UserController {
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping // http:localhost:8080/api/v1/users
	ResponseEntity<User> createUser(@RequestBody User newUser) {
	   User registeredUser = userService.createUser(newUser);
	   return ResponseEntity.status(201).body(registeredUser);
	}
	
	@GetMapping("{id}") // http:localhost:8080/api/v1/users/{id} 
	User getUserById(@PathVariable("id") Long id){
		User existingUser = userService.getUserById(id);
		return existingUser;
	}
	
	/*
	@GetMapping("{email}")
    User getUserByEmail(@PathVariable("email") String email) {
		User existingUser = userService.getUserByEmail(email);
        return existingUser;
    }
	*/
	
	@GetMapping("/all") // http:localhost:8080/api/v1/users?active=false
	Set<User> getAllUsers(
			@RequestParam(
					name="active", 
					required = false,
					defaultValue = "true"
					) boolean active  
			){
		return userService.getAllUsers(active);
	}
	
	
	@PutMapping("{id}") // http:localhost:8080/api/v1/users/{id}
	ResponseEntity<User> updatedUser(@PathVariable("id") Long id ,@RequestBody User user) {
		User updatedUser = userService.updateUser(user, id);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("{id}") // http:localhost:8080/api/v1/users/{id}
	ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok("Usuario con id " + id + " ha sido eliminado");
		// return ResponseEntity.noContent(); Status 204
	}
}
