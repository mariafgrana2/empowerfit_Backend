package com.empowerfit.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
	
	// SELECT * FROM status WHERE name_status = ?
    List<Status> findByStatus(String status);

 // Busca un Privilege específico por id (REVISAR)
    Status findById(long id);
    
 // Encuentra todos los Status únicos por nombre
    Set<Status> findAllByStatus(String status);
    
}
