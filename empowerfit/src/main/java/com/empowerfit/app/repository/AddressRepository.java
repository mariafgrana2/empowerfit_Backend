package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

    // SELECT * FROM address WHERE city = ?
    List<Address> findByCity(String city);

    // SELECT * FROM address WHERE state = ?
    List<Address> findByState(String state);

    // SELECT * FROM address WHERE country = ?
    List<Address> findByCountry(String country);

    // Busca una Address específica por postal code
    Optional<Address> findByPostalCode(int postalCode);

    // Sobrecarga de método para buscar por ID
    Address findById(long id);

    // Obtiene todas las direcciones en un país específico
    Set<Address> findAllByCountry(String country);
}
