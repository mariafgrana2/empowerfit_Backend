package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

    // SELECT * FROM address WHERE city = ?
    List<Address> findByCity(String city);

    // SELECT * FROM address WHERE state = ?
    List<Address> findByState(String state);

    // Busca una Address específica por postal code
    Optional<Address> findByPostalCode(String postalCode);

    // Sobrecarga de método para buscar por ID
    Address findById(long id);
    
}
