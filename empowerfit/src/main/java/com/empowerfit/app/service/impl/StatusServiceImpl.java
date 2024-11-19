package com.empowerfit.app.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Status;
import com.empowerfit.app.repository.StatusRepository;
import com.empowerfit.app.service.StatusService;

public class StatusServiceImpl implements StatusService {
	
	StatusRepository statusRepository;
	/* La inyeccion de dependencia por constructor*/
	public StatusServiceImpl(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	@Override
	public Status createStatus(Status status) {
		Status newStatus = statusRepository.save(status);
		return newStatus;
	}

	@Override
	public Status getStatusById(Long id) {
        return statusRepository.findById(id).orElseThrow(() ->
            new IllegalStateException("No existe un estado con id " + id));
    }

	@Override
	public Status getStatusByName(String statusName) {
		List<Status> status = statusRepository.findByStatus(statusName);
        if (status.isEmpty()) {
            throw new IllegalStateException("No existe un estado con el nombre: " + statusName);
        }
        return status.get(0);
    }

	@Override
	public Status updateStatus(Status status, Long id) {
		Status existingStatus = getStatusById(id);
		existingStatus.setStatus(status.getStatus());
		return statusRepository.save(existingStatus);
	}

	@Override
	public void deleteStatus(Long id) {
		Status status = getStatusById(id);
		statusRepository.delete(status);
	}

	@Override
	public Optional<Status> findByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
