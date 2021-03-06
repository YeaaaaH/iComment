package com.fellas.usersservice.controller;

import com.fellas.usersservice.exception.RoleNotFoundException;
import com.fellas.usersservice.exception.UserNotFoundException;
import com.fellas.usersservice.model.Role;
import com.fellas.usersservice.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
public class RolesController {

    private final RoleService service;

    public RolesController(RoleService service) {
        this.service = service;
    }

    @GetMapping("hello")
    public String sayHello() {
        return "Hello from Docker! ;)";
    }

    @GetMapping("{id}")
    public Role getById(@PathVariable("id") long id) throws RoleNotFoundException {
        return service.findRoleById(id);
    }

    @GetMapping("all")
    public List<Role> getAllRoles() {
        return service.getAllRoles();
    }

    @PostMapping("create")
    public Role create(@RequestBody Role role) {
        return service.saveRole(role);
    }

    @PutMapping("update")
    public Role update(@RequestBody Role role) {
        return service.saveRole(role);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws RoleNotFoundException {
        return service.deleteRoleById(id);
    }
}
