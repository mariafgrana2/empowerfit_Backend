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
<<<<<<< HEAD
    Set<Status> findAllByStatus(String status);

=======
    Set<Status> findAllByNameStatus(String nameStatus);
>>>>>>> 0294e444b3f39e3757777897e81ba4d2cee21326
}
