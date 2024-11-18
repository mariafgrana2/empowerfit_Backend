package com.empowerfit.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.empowerfit.app.model.Privilege;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "privilege", path = "roles")
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
	
	// SELECT * FROM privilege WHERE privilege = ?
	List<Privilege> findByPrivilege(String privilege);
	
	// Busca un Privilege específico por id (REVISAR)
	   Privilege findById(long id);
	
	// Encontrar todos los privilegios únicos
	Set<Privilege> findAllByPrivilege(String privilege);
	
	

}
