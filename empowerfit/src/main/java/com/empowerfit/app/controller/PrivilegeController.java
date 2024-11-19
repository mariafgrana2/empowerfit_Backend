package com.empowerfit.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empowerfit.app.model.Privilege;
import com.empowerfit.app.service.PrivilegeService;

@CrossOrigin(origins = "*")
@Controller
@ResponseBody
@RequestMapping("/api/v1/privileges")
public class PrivilegeController {
    private final PrivilegeService privilegeService;

    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    @PostMapping // http://localhost:8080/api/v1/privileges
    ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege newPrivilege) {
        Privilege createdPrivilege = privilegeService.createPrivilege(newPrivilege);
        return ResponseEntity.status(201).body(createdPrivilege);
    }

    @GetMapping("{id}") // http://localhost:8080/api/v1/privileges/{id}
    Privilege getPrivilegeById(@PathVariable("id") Long id) {
        return privilegeService.getPrivilegeById(id);
    }

    @GetMapping("/n") // http://localhost:8080/api/v1/privileges/n?name={privilegeName}
    Privilege getPrivilegeByName(@RequestParam("name") String privilegeName) {
        return privilegeService.getPrivilegeByName(privilegeName);
    }

    @PutMapping("{id}") // http://localhost:8080/api/v1/privileges/{id}
    ResponseEntity<Privilege> updatePrivilege(@PathVariable("id") Long id, @RequestBody Privilege privilege) {
        Privilege updatedPrivilege = privilegeService.updatePrivilege(privilege, id);
        return ResponseEntity.ok(updatedPrivilege);
    }

    @DeleteMapping("{id}") // http://localhost:8080/api/v1/privileges/{id}
    ResponseEntity<String> deletePrivilege(@PathVariable("id") Long id) {
        privilegeService.deletePrivilege(id);
        return ResponseEntity.ok("Privilegio con id " + id + " ha sido eliminado");
    }
}