package com.empowerfit.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
