package com.fellas.iComment.service;

import com.fellas.iComment.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RoleService {
    private final RestTemplate restTemplate;

    public RoleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Role getRoleById(long id) {
        return restTemplate.getForObject("http://localhost:8082/role/" + id, Role.class);
    }

    public List<Role> getAllRoles() {
        return restTemplate.getForObject("http://localhost:8082/role/all", List.class);
    }
}
