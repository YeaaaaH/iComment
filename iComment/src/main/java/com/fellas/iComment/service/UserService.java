package com.fellas.iComment.service;

import com.fellas.iComment.model.Role;
import com.fellas.iComment.model.User;
import org.springframework.stereotype.Service;
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
}
