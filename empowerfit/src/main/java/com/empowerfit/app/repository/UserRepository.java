package com.empowerfit.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {

    // Encuentra un usuario por su correo electrónico.
    User findByEmail(String email);

    // Encuentra un usuario por su número de teléfono.
    User findByPhone(String phone);

    // Encuentra todos los usuarios activos.
    Set<User> findAllByActiveTrue();

    //Encuentra todos los usuarios inactivos.
    Set<User> findAllByActiveFalse();
    
    // Encuentra un usuario por su ID.
    Optional<User> findById(Long id);
    
}
