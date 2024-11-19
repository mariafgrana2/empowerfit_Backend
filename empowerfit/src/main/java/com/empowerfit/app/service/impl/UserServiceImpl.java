package com.empowerfit.app.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.User;
import com.empowerfit.app.repository.UserRepository;
import com.empowerfit.app.service.UserService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Service
public class UserServiceImpl implements UserService {
	UserRepository userRepository;	
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User createUser(User user) {
		 Set<ConstraintViolation<User>> violations = validator.validate(user);

	        if (!violations.isEmpty()) {
	            // Si hay violaciones de validación, lanzar una excepción o retornar un error
	            StringBuilder errorMessage = new StringBuilder("Validation failed: ");
	            for (ConstraintViolation<User> violation : violations) {
	                errorMessage.append(violation.getMessage()).append(" ");
	            }
	            throw new IllegalStateException(errorMessage.toString());
	        }
		
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if(optionalUser.isPresent()) {
			throw new IllegalStateException("Ya existe un usuario registrado con este correo " + user.getEmail());
		}
		
		user.setActive(true);
		user.setId(null);
		user.setCreatedAt(LocalDateTime.now());
		User newUser = userRepository.save( user );
		return newUser;
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if( optionalUser.isEmpty()) {
			throw new IllegalStateException("No existe el usuario con id " + id);
		}
		User existingUser = optionalUser.get();
		return existingUser;
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if( optionalUser.isEmpty()) {
			throw new IllegalStateException("No existe el usuario con correo: " + email);
		}
		User existingUser = optionalUser.get();
		return existingUser;
	}

	@Override
	public User getUserByPhone(String phone) {
		Optional<User> optionalUser = userRepository.findByPhone(phone);
		if( optionalUser.isEmpty()) {
			throw new IllegalStateException("No existe el usuario con número de celular: " + phone);
		}
		User existingUser = optionalUser.get();
		return existingUser;
	}

	@Override
	public Set<User> getAllUsers(boolean active) {
		Set<User> users;
		if( active ) {
			users = userRepository.findAllByActiveTrue();
		} else {
			users = userRepository.findAllByActiveFalse();
		}
		return users;
	}


	@Override
	public User updateUser(User user, Long id) {
		User existingUser = getUserById(id);
		existingUser.setName( user.getName() );
		existingUser.setPhone( user.getPhone() );
		existingUser.setPassword( user.getPassword() );
		existingUser.setUpdatedAt(LocalDateTime.now());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		existingUser.setActive(false);
		userRepository.save(existingUser);
		
	}

}
