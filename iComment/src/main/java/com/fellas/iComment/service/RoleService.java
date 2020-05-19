package com.fellas.iComment.service;

import com.fellas.iComment.model.Role;
import com.fellas.iComment.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleById(long id) {
        return roleRepository.findById(id).get();
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public String deleteRoleById(long id) {
        roleRepository.deleteById(id);
        return "Role with id: " + id + "was deleted";
    }

    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        roleRepository.findAll().forEach(list::add);
        return list;
    }


}
