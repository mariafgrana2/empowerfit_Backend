package com.empowerfit.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
	
	// SELECT * FROM privilege WHERE privilege = ?
	List<Privilege> findByPrivilege(String privilege);
	
	// Busca un Privilege específico por id (REVISAR)
	   Privilege findById(long id);
	
	// Encontrar todos los privilegios únicos
	Set<Privilege> findAllByPrivilege(String privilege);
	
	

}
