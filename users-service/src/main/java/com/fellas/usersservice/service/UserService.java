package com.fellas.usersservice.service;

import com.fellas.usersservice.exception.UserNotFoundException;
import com.fellas.usersservice.model.User;
import com.fellas.usersservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " han not been found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<String> deleteUserById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " had not been found"));
        userRepository.delete(user);
        return ResponseEntity.status(HttpStatus.OK).body("User with id " + id + " had been deleted");
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }
}
