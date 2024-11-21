package com.empowerfit.app.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.empowerfit.app.model.User;
import com.empowerfit.app.repository.UserRepository;
import com.empowerfit.app.service.LoginUserService;

@Service
public class UserLoginServiceImpl implements LoginUserService  {
	
	UserRepository userRepository;
	
	public UserLoginServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User loginCustomer(User user) {
		String email = user.getEmail();
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if( optionalUser.isPresent() ) {
			User existingUser = optionalUser.get();
			if( existingUser.getPassword().equals( user.getPassword()) ) {
				return existingUser;
			}
		}
		throw new IllegalStateException("Incorrect e-mail or password");				
	}
}
