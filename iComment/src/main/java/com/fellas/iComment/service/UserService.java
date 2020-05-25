package com.fellas.iComment.service;

import com.fellas.iComment.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getRoleById(long id) {
        return restTemplate.getForObject("http://localhost:8082/user/" + id, User.class);
    }

    public List<User> getAllUsers() {
        return restTemplate.getForObject("http://localhost:8082/user/all", List.class);
    }

    public ResponseEntity<User> createUser(User user) {
        HttpEntity<User> request = new HttpEntity<>(user);
        return restTemplate.postForEntity("http://localhost:8082/user/create", request, User.class);
    }

    public ResponseEntity<User> updateUser(User user) {
        HttpEntity<User> request = new HttpEntity<>(user);
        return restTemplate.exchange("http://localhost:8082/user/update", HttpMethod.PUT, request, User.class);
    }

    public ResponseEntity<String> deleteUserById(long id) {
        try {
            restTemplate.delete("http://localhost:8082/user/" + id);
            return ResponseEntity.status(HttpStatus.OK).body("User with id " + id + " had been deleted");
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response from server: " + exception.getStatusCode().toString());
        }
    }
}
