package com.empowerfit.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Privilege;
import com.empowerfit.app.repository.PrivilegeRepository;
import com.empowerfit.app.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege createPrivilege(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    @Override
    public Privilege getPrivilegeById(Long id) {
        return privilegeRepository.findById(id).orElseThrow(() ->
            new IllegalStateException("No existe un privilegio con id " + id));
    }

    @Override
    public Privilege getPrivilegeByName(String privilegeName) {
        List<Privilege> privileges = privilegeRepository.findByPrivilege(privilegeName);
        if (privileges.isEmpty()) {
            throw new IllegalStateException("No existe un privilegio con el nombre: " + privilegeName);
        }
        return privileges.get(0);
    }

    @Override
    public Privilege updatePrivilege(Privilege privilege, Long id) {
        Privilege existingPrivilege = getPrivilegeById(id);
        existingPrivilege.setPrivilege(privilege.getPrivilege());
        return privilegeRepository.save(existingPrivilege);
    }

    @Override
    public void deletePrivilege(Long id) {
        Privilege privilege = getPrivilegeById(id);
        privilegeRepository.delete(privilege);
    }
}
