package com.empowerfit.app.service;

import java.util.Set;
import com.empowerfit.app.model.Status;

public interface StatusService {
	
	 Status createStatus(Status status);
	 Status getStatusById(Long id);
	 Status getStatusByName(String nameStatus);
	 Status updateStatus(Status status, Long id);
	 void deleteStatus(Long id);

}
