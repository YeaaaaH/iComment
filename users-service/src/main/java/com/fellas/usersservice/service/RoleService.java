package com.fellas.usersservice.service;

import com.fellas.usersservice.exception.RoleNotFoundException;
import com.fellas.usersservice.model.Role;
import com.fellas.usersservice.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleById(long id) throws RoleNotFoundException {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " had not been found"));
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public ResponseEntity<String> deleteRoleById(long id) throws RoleNotFoundException {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " had not been found"));
        roleRepository.delete(role);
        return ResponseEntity.status(HttpStatus.OK).body("Role with id " + id + " had been deleted");
    }

    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        roleRepository.findAll().forEach(list::add);
        return list;
    }
}
