package com.fellas.usersservice.repository;

import com.fellas.usersservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
