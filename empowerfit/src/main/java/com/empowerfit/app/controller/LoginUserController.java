package com.empowerfit.app.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empowerfit.app.model.User;
import com.empowerfit.app.service.LoginUserService;


@RestController
@RequestMapping("api/v1/login")
@CrossOrigin(origins = "*")
public class LoginUserController {
	LoginUserService loginUserService;

	public LoginUserController(LoginUserService loginUserService) {	
		this.loginUserService = loginUserService;
	}
	
	@PostMapping
	ResponseEntity<User> loginUser(@RequestBody User user){
		User existingUser =  loginUserService.loginCustomer(user);
		return ResponseEntity.ok(existingUser);
	}
	
}