package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Size;

public interface SizeRepository extends CrudRepository<Size, Long> {

    List<Size> findBySize(String size); //talla por nombre
    Optional<Size> findById(Long id); // talla por id
    Set<Size> findAll(); //Todas las tallas
}

