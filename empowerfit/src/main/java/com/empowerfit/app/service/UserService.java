package com.empowerfit.app.service;

import java.util.Set;

import com.empowerfit.app.model.User;

public interface UserService {
    //Crea un nuevo usuario.
    User createUser(User user);

    //Obtiene un usuario por su ID.
    User getUserById(Long id);

    // Obtiene un usuario por su correo electrónico.
    User getUserByEmail(String email);

    // Obtiene un usuario por su número de teléfono.
    User getUserByPhone(String phone);
    
    // Obtiene todos los usuarios activos.
    Set<User> getActiveUsers();

    // Obtiene todos los usuarios inactivos.
    Set<User> getInactiveUsers();

    // Actualiza la información de un usuario existente.
    User updateUser(User user, Long id);

    // Elimina un usuario por su ID.
    void deleteUser(Long id);
}