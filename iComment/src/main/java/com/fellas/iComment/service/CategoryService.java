package com.fellas.iComment.service;

import com.fellas.iComment.model.Category;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CategoryService {

    private final RestTemplate restTemplate;

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Category getCategoryById(long id) {
        return restTemplate.getForObject("http://localhost:8081/category/" + id, Category.class);
    }

    public List<Category> getAllCategories() {
        return restTemplate.getForObject("http://localhost:8081/category/all", List.class);
    }

    public ResponseEntity<Category> createCategory(Category category) {
        HttpEntity<Category> request = new HttpEntity<>(category);
        return restTemplate.postForEntity("http://localhost:8081/category/create", request, Category.class);
    }

    public ResponseEntity<Category> updateCategory(Category category) {
        HttpEntity<Category> request = new HttpEntity<>(category);
        return restTemplate.exchange("http://localhost:8081/category/update", HttpMethod.PUT, request, Category.class);
    }

    public ResponseEntity<String> deleteCategoryById(long id) {
        try {
            restTemplate.delete("http://localhost:8081/category/" + id);
            return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " had been deleted");
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response from server: " + exception.getStatusCode().toString());
        }
    }
}
