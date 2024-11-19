package com.empowerfit.app.service;

import java.util.Optional;

import com.empowerfit.app.model.Status;

public interface StatusService {
	
	 Status createStatus(Status status);
	 Status getStatusById(Long id);
	 Status getStatusByName(String nameStatus);
	 Optional<Status> findByName(String name);
	 Status updateStatus(Status status, Long id);
	 void deleteStatus(Long id);

}
