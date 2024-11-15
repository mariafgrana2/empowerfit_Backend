package com.empowerfit.app.service;

import com.empowerfit.app.model.Privilege;

public interface PrivilegeService {
	
	Privilege createPrivilege(Privilege privilege);
    Privilege getPrivilegeById(Long id);
    Privilege getPrivilegeByName(String privilegeName);
    Privilege updatePrivilege(Privilege privilege, Long id);
    void deletePrivilege(Long id);

}
