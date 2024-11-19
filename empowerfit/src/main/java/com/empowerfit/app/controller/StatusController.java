package com.empowerfit.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empowerfit.app.model.Status;
import com.empowerfit.app.service.StatusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/statuses") // http://localhost:8080/api/v1/statuses
public class StatusController {
	StatusService statusService;

	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}
	
	@GetMapping("{id}") // http://localhost:8080/api/v1/statuses/{id}
	Status getStatusById(@PathVariable("id") Long id){
		return statusService.getStatusById(id);
	}
	
	@PostMapping // http://localhost:8080/api/v1/statuses
	ResponseEntity<Status> createStatus(@RequestBody Status newStatus){
		Status createdStatus = statusService.createStatus(newStatus);
		return ResponseEntity.status(201).body(createdStatus);
	}
	
	@GetMapping ("/n") // // http://localhost:8080/api/v1/statuses/n?name={statusName}
	Status getStatusByName(@RequestParam("name") String statusName) {
		return statusService.getStatusByName(statusName);
	}
	
	
	
}
