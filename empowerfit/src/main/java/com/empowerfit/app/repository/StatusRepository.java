package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
	
	// SELECT * FROM status WHERE name_status = ?
    List<Status> findByNameStatus(String nameStatus);

 // Busca un Privilege específico por id (REVISAR)
    Optional<Status> findById(Long id);
    
 // Encuentra todos los Status únicos por nombre
    Set<Status> findAllByNameStatus(String nameStatus);

}
