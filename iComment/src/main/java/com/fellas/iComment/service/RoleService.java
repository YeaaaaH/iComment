package com.fellas.iComment.service;

import com.fellas.iComment.model.Role;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoleService {

    private final RestTemplate restTemplate;

    public RoleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Role getRoleById(long id) {
        try {
            return restTemplate.getForObject("http://localhost:8082/role/" + id, Role.class);
        } catch (HttpClientErrorException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response from user-service: " + exception.getStatusCode());
        }
    }

    public List<Role> getAllRoles() {
        return restTemplate.getForObject("http://localhost:8082/role/all", List.class);
    }

    public ResponseEntity<Role> createRole(Role role) {
        HttpEntity<Role> request = new HttpEntity<>(role);
        return restTemplate.postForEntity("http://localhost:8082/role/create", request, Role.class);
    }

    public ResponseEntity<Role> updateRole(Role role) {
        HttpEntity<Role> request = new HttpEntity<>(role);
        return restTemplate.exchange("http://localhost:8082/role/update", HttpMethod.PUT, request, Role.class);
    }

    public ResponseEntity<String> deleteRoleById(long id) {
        try {
            restTemplate.delete("http://localhost:8082/role/" + id);
            return ResponseEntity.status(HttpStatus.OK).body("Role with id " + id + " had been deleted");
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response from server: " + exception.getStatusCode().toString());
        }
    }
}
