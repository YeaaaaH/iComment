package com.fellas.usersservice.repository;

import com.fellas.usersservice.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}

