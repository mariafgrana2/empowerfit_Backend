package com.empowerfit.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
