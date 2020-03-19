package com.fellas.iComment.service;

import com.fellas.iComment.model.User;
import com.fellas.iComment.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public String deleteUserById(long id) {
        userRepository.deleteById(id);
        return "User with id: " + id + "was deleted";
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

}
