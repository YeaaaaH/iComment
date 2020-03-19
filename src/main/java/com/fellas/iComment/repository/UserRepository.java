package com.fellas.iComment.repository;

import com.fellas.iComment.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
